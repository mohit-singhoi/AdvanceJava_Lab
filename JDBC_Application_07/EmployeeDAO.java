package JDBC_Application_07;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EmployeeDAO {
    
    // Create employees table if not exists
    public void createTable() {
        String sql = "BEGIN " +
                    "   EXECUTE IMMEDIATE 'CREATE TABLE employees (" +
                    "       emp_id NUMBER PRIMARY KEY, " +
                    "       name VARCHAR2(100) NOT NULL, " +
                    "       email VARCHAR2(100) UNIQUE, " +
                    "       phone VARCHAR2(15), " +
                    "       department VARCHAR2(50), " +
                    "       designation VARCHAR2(50), " +
                    "       salary NUMBER(10,2), " +
                    "       hire_date DATE DEFAULT SYSDATE, " +
                    "       address VARCHAR2(200)" +
                    "   )'; " +
                    "EXCEPTION " +
                    "   WHEN OTHERS THEN " +
                    "       IF SQLCODE != -955 THEN RAISE; END IF; " +
                    "END;";
        
        try (CallableStatement cstmt = DatabaseConnection.getConnection().prepareCall(sql)) {
            cstmt.execute();
            System.out.println("✅ Employee table checked/created.");
            
            // Insert sample data if table is empty
            insertSampleData();
            
        } catch (SQLException e) {
            System.out.println("Note: " + e.getMessage());
        }
    }
    
    private void insertSampleData() {
        String checkSql = "SELECT COUNT(*) FROM employees";
        try (Statement stmt = DatabaseConnection.getConnection().createStatement();
             ResultSet rs = stmt.executeQuery(checkSql)) {
            
            if (rs.next() && rs.getInt(1) == 0) {
                String[] inserts = {
                    "INSERT INTO employees VALUES (101, 'John Smith', 'john.smith@email.com', '9876543210', 'IT', 'Software Engineer', 75000, TO_DATE('2023-01-15', 'YYYY-MM-DD'), '123 Main St')",
                    "INSERT INTO employees VALUES (102, 'Jane Doe', 'jane.doe@email.com', '9876543211', 'HR', 'HR Manager', 65000, TO_DATE('2022-03-10', 'YYYY-MM-DD'), '456 Oak Ave')",
                    "INSERT INTO employees VALUES (103, 'Robert Johnson', 'robert.j@email.com', '9876543212', 'Sales', 'Sales Executive', 55000, TO_DATE('2023-06-20', 'YYYY-MM-DD'), '789 Pine Rd')",
                    "INSERT INTO employees VALUES (104, 'Sarah Williams', 'sarah.w@email.com', '9876543213', 'IT', 'Database Admin', 80000, TO_DATE('2021-11-05', 'YYYY-MM-DD'), '321 Elm St')",
                    "INSERT INTO employees VALUES (105, 'Michael Brown', 'michael.b@email.com', '9876543214', 'Finance', 'Accountant', 60000, TO_DATE('2023-08-30', 'YYYY-MM-DD'), '654 Maple Dr')"
                };
                
                for (String insert : inserts) {
                    stmt.executeUpdate(insert);
                }
                DatabaseConnection.commit();
                System.out.println("✅ Sample data inserted.");
            }
        } catch (SQLException e) {
            DatabaseConnection.rollback();
            System.out.println("❌ Error inserting sample data: " + e.getMessage());
        }
    }
    
    // Add new employee
    public boolean addEmployee(Employee emp) {
        String sql = "INSERT INTO employees (emp_id, name, email, phone, department, designation, salary, address) " +
                    "VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
        
        try (PreparedStatement pstmt = DatabaseConnection.getConnection().prepareStatement(sql)) {
            pstmt.setInt(1, emp.getEmpId());
            pstmt.setString(2, emp.getName());
            pstmt.setString(3, emp.getEmail());
            pstmt.setString(4, emp.getPhone());
            pstmt.setString(5, emp.getDepartment());
            pstmt.setString(6, emp.getDesignation());
            pstmt.setDouble(7, emp.getSalary());
            pstmt.setString(8, emp.getAddress());
            
            int rows = pstmt.executeUpdate();
            DatabaseConnection.commit();
            return rows > 0;
            
        } catch (SQLException e) {
            DatabaseConnection.rollback();
            throw new RuntimeException("Error adding employee: " + e.getMessage(), e);
        }
    }
    
    // Get all employees
    public List<Employee> getAllEmployees() {
        List<Employee> employees = new ArrayList<>();
        String sql = "SELECT * FROM employees ORDER BY emp_id";
        
        try (Statement stmt = DatabaseConnection.getConnection().createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            
            while (rs.next()) {
                employees.add(mapResultSetToEmployee(rs));
            }
            
        } catch (SQLException e) {
            throw new RuntimeException("Error retrieving employees: " + e.getMessage(), e);
        }
        return employees;
    }
    
    // Get employee by ID
    public Employee getEmployeeById(int empId) {
        String sql = "SELECT * FROM employees WHERE emp_id = ?";
        
        try (PreparedStatement pstmt = DatabaseConnection.getConnection().prepareStatement(sql)) {
            pstmt.setInt(1, empId);
            ResultSet rs = pstmt.executeQuery();
            
            if (rs.next()) {
                return mapResultSetToEmployee(rs);
            }
            return null;
            
        } catch (SQLException e) {
            throw new RuntimeException("Error retrieving employee: " + e.getMessage(), e);
        }
    }
    
    // Search employees by name
    public List<Employee> searchEmployeesByName(String name) {
        List<Employee> employees = new ArrayList<>();
        String sql = "SELECT * FROM employees WHERE UPPER(name) LIKE UPPER(?) ORDER BY emp_id";
        
        try (PreparedStatement pstmt = DatabaseConnection.getConnection().prepareStatement(sql)) {
            pstmt.setString(1, "%" + name + "%");
            ResultSet rs = pstmt.executeQuery();
            
            while (rs.next()) {
                employees.add(mapResultSetToEmployee(rs));
            }
            
        } catch (SQLException e) {
            throw new RuntimeException("Error searching employees: " + e.getMessage(), e);
        }
        return employees;
    }
    
    // Update employee
    public boolean updateEmployee(Employee emp) {
        String sql = "UPDATE employees SET name = ?, email = ?, phone = ?, " +
                    "department = ?, designation = ?, salary = ?, address = ? " +
                    "WHERE emp_id = ?";
        
        try (PreparedStatement pstmt = DatabaseConnection.getConnection().prepareStatement(sql)) {
            pstmt.setString(1, emp.getName());
            pstmt.setString(2, emp.getEmail());
            pstmt.setString(3, emp.getPhone());
            pstmt.setString(4, emp.getDepartment());
            pstmt.setString(5, emp.getDesignation());
            pstmt.setDouble(6, emp.getSalary());
            pstmt.setString(7, emp.getAddress());
            pstmt.setInt(8, emp.getEmpId());
            
            int rows = pstmt.executeUpdate();
            DatabaseConnection.commit();
            return rows > 0;
            
        } catch (SQLException e) {
            DatabaseConnection.rollback();
            throw new RuntimeException("Error updating employee: " + e.getMessage(), e);
        }
    }
    
    // Delete employee
    public boolean deleteEmployee(int empId) {
        String sql = "DELETE FROM employees WHERE emp_id = ?";
        
        try (PreparedStatement pstmt = DatabaseConnection.getConnection().prepareStatement(sql)) {
            pstmt.setInt(1, empId);
            
            int rows = pstmt.executeUpdate();
            DatabaseConnection.commit();
            return rows > 0;
            
        } catch (SQLException e) {
            DatabaseConnection.rollback();
            throw new RuntimeException("Error deleting employee: " + e.getMessage(), e);
        }
    }
    
    // Get department statistics
    public List<DepartmentStats> getDepartmentStatistics() {
        List<DepartmentStats> stats = new ArrayList<>();
        String sql = "SELECT department, COUNT(*) as emp_count, " +
                    "AVG(salary) as avg_salary, MIN(salary) as min_salary, " +
                    "MAX(salary) as max_salary, SUM(salary) as total_salary " +
                    "FROM employees GROUP BY department ORDER BY department";
        
        try (Statement stmt = DatabaseConnection.getConnection().createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            
            while (rs.next()) {
                DepartmentStats deptStats = new DepartmentStats();
                deptStats.setDepartment(rs.getString("department"));
                deptStats.setEmployeeCount(rs.getInt("emp_count"));
                deptStats.setAvgSalary(rs.getDouble("avg_salary"));
                deptStats.setMinSalary(rs.getDouble("min_salary"));
                deptStats.setMaxSalary(rs.getDouble("max_salary"));
                deptStats.setTotalSalary(rs.getDouble("total_salary"));
                stats.add(deptStats);
            }
            
        } catch (SQLException e) {
            throw new RuntimeException("Error getting department stats: " + e.getMessage(), e);
        }
        return stats;
    }
    
    // Helper method to map ResultSet to Employee object
    private Employee mapResultSetToEmployee(ResultSet rs) throws SQLException {
        Employee emp = new Employee();
        emp.setEmpId(rs.getInt("emp_id"));
        emp.setName(rs.getString("name"));
        emp.setEmail(rs.getString("email"));
        emp.setPhone(rs.getString("phone"));
        emp.setDepartment(rs.getString("department"));
        emp.setDesignation(rs.getString("designation"));
        emp.setSalary(rs.getDouble("salary"));
        emp.setHireDate(rs.getDate("hire_date"));
        emp.setAddress(rs.getString("address"));
        return emp;
    }
    
    // Inner class for department statistics
    public static class DepartmentStats {
        private String department;
        private int employeeCount;
        private double avgSalary;
        private double minSalary;
        private double maxSalary;
        private double totalSalary;
        
        // Getters and Setters
        public String getDepartment() { return department; }
        public void setDepartment(String department) { this.department = department; }
        
        public int getEmployeeCount() { return employeeCount; }
        public void setEmployeeCount(int employeeCount) { this.employeeCount = employeeCount; }
        
        public double getAvgSalary() { return avgSalary; }
        public void setAvgSalary(double avgSalary) { this.avgSalary = avgSalary; }
        
        public double getMinSalary() { return minSalary; }
        public void setMinSalary(double minSalary) { this.minSalary = minSalary; }
        
        public double getMaxSalary() { return maxSalary; }
        public void setMaxSalary(double maxSalary) { this.maxSalary = maxSalary; }
        
        public double getTotalSalary() { return totalSalary; }
        public void setTotalSalary(double totalSalary) { this.totalSalary = totalSalary; }
    }
}