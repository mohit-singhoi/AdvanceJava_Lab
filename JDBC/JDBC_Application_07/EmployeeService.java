package JDBC_Application_07;

import java.util.List;

public class EmployeeService {
    private EmployeeDAO employeeDAO;
    
    public EmployeeService() {
        this.employeeDAO = new EmployeeDAO();
    }
    
    // Initialize database
    public void initializeDatabase() {
        employeeDAO.createTable();
    }
    
    // Add employee with validation
    public boolean addEmployee(Employee emp) {
        if (emp == null) {
            throw new IllegalArgumentException("Employee cannot be null");
        }
        
        // Basic validation
        if (emp.getName() == null || emp.getName().trim().isEmpty()) {
            throw new IllegalArgumentException("Employee name is required");
        }
        
        if (emp.getEmail() == null || emp.getEmail().trim().isEmpty()) {
            throw new IllegalArgumentException("Employee email is required");
        }
        
        if (emp.getSalary() < 0) {
            throw new IllegalArgumentException("Salary cannot be negative");
        }
        
        return employeeDAO.addEmployee(emp);
    }
    
    // Get all employees
    public List<Employee> getAllEmployees() {
        return employeeDAO.getAllEmployees();
    }
    
    // Get employee by ID
    public Employee getEmployeeById(int empId) {
        return employeeDAO.getEmployeeById(empId);
    }
    
    // Search employees
    public List<Employee> searchEmployees(String searchType, String searchValue) {
        switch (searchType.toLowerCase()) {
            case "name":
                return employeeDAO.searchEmployeesByName(searchValue);
            case "department":
                return searchByDepartment(searchValue);
            default:
                throw new IllegalArgumentException("Invalid search type: " + searchType);
        }
    }
    
    private List<Employee> searchByDepartment(String department) {
        List<Employee> allEmployees = employeeDAO.getAllEmployees();
        return allEmployees.stream()
                .filter(emp -> emp.getDepartment().equalsIgnoreCase(department))
                .toList();
    }
    
    // Update employee
    public boolean updateEmployee(Employee emp) {
        if (emp == null) {
            throw new IllegalArgumentException("Employee cannot be null");
        }
        
        // Check if employee exists
        Employee existing = getEmployeeById(emp.getEmpId());
        if (existing == null) {
            throw new IllegalArgumentException("Employee with ID " + emp.getEmpId() + " not found");
        }
        
        return employeeDAO.updateEmployee(emp);
    }
    
    // Delete employee
    public boolean deleteEmployee(int empId) {
        // Check if employee exists
        Employee existing = getEmployeeById(empId);
        if (existing == null) {
            throw new IllegalArgumentException("Employee with ID " + empId + " not found");
        }
        
        return employeeDAO.deleteEmployee(empId);
    }
    
    // Get department statistics
    public List<EmployeeDAO.DepartmentStats> getDepartmentStatistics() {
        return employeeDAO.getDepartmentStatistics();
    }
    
    // Get company-wide statistics
    public CompanyStats getCompanyStatistics() {
        List<Employee> employees = employeeDAO.getAllEmployees();
        
        CompanyStats stats = new CompanyStats();
        stats.setTotalEmployees(employees.size());
        
        if (!employees.isEmpty()) {
            double totalSalary = employees.stream().mapToDouble(Employee::getSalary).sum();
            double avgSalary = totalSalary / employees.size();
            double minSalary = employees.stream().mapToDouble(Employee::getSalary).min().orElse(0);
            double maxSalary = employees.stream().mapToDouble(Employee::getSalary).max().orElse(0);
            
            stats.setAvgSalary(avgSalary);
            stats.setMinSalary(minSalary);
            stats.setMaxSalary(maxSalary);
            stats.setTotalSalary(totalSalary);
        }
        
        return stats;
    }
    
    // Inner class for company statistics
    public static class CompanyStats {
        private int totalEmployees;
        private double avgSalary;
        private double minSalary;
        private double maxSalary;
        private double totalSalary;
        
        // Getters and Setters
        public int getTotalEmployees() { return totalEmployees; }
        public void setTotalEmployees(int totalEmployees) { this.totalEmployees = totalEmployees; }
        
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