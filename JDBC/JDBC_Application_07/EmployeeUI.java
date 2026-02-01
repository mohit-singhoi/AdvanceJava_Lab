package JDBC_Application_07;

import java.util.List;
import java.util.Scanner;

public class EmployeeUI {
    private Scanner scanner;
    private EmployeeService employeeService;
    
    public EmployeeUI() {
        this.scanner = new Scanner(System.in);
        this.employeeService = new EmployeeService();
    }
    
    public void displayMainMenu() {
        System.out.println("╔══════════════════════════════════════╗");
        System.out.println("║    EMPLOYEE MANAGEMENT SYSTEM        ║");
        System.out.println("║    Oracle JDBC Application           ║");
        System.out.println("╚══════════════════════════════════════╝");
    }
    
    public int showMenuAndGetChoice() {
        System.out.println("\n" + "=".repeat(50));
        System.out.println("           MAIN MENU");
        System.out.println("=".repeat(50));
        System.out.println("1. Add New Employee");
        System.out.println("2. View All Employees");
        System.out.println("3. Search Employee");
        System.out.println("4. Update Employee");
        System.out.println("5. Delete Employee");
        System.out.println("6. Department Statistics");
        System.out.println("7. Company Statistics");
        System.out.println("8. Exit");
        System.out.println("=".repeat(50));
        
        return getIntInput("Enter your choice (1-8): ", 1, 8);
    }
    
    public void handleChoice(int choice) {
        switch (choice) {
            case 1:
                addEmployee();
                break;
            case 2:
                viewAllEmployees();
                break;
            case 3:
                searchEmployee();
                break;
            case 4:
                updateEmployee();
                break;
            case 5:
                deleteEmployee();
                break;
            case 6:
                viewDepartmentStats();
                break;
            case 7:
                viewCompanyStats();
                break;
            case 8:
                System.out.println("\nThank you for using Employee Management System!");
                break;
            default:
                System.out.println("Invalid choice!");
        }
    }
    
    private void addEmployee() {
        System.out.println("\n--- ADD NEW EMPLOYEE ---");
        
        Employee emp = new Employee();
        emp.setEmpId(getIntInput("Employee ID: "));
        emp.setName(getStringInput("Full Name: "));
        emp.setEmail(getStringInput("Email: "));
        emp.setPhone(getStringInput("Phone: "));
        emp.setDepartment(getStringInput("Department: "));
        emp.setDesignation(getStringInput("Designation: "));
        emp.setSalary(getDoubleInput("Salary: "));
        emp.setAddress(getStringInput("Address: "));
        
        try {
            if (employeeService.addEmployee(emp)) {
                System.out.println("✅ Employee added successfully!");
            }
        } catch (Exception e) {
            System.out.println("❌ Error: " + e.getMessage());
        }
    }
    
    private void viewAllEmployees() {
        System.out.println("\n--- ALL EMPLOYEES ---");
        
        try {
            List<Employee> employees = employeeService.getAllEmployees();
            
            if (employees.isEmpty()) {
                System.out.println("No employees found.");
                return;
            }
            
            System.out.println("┌─────┬────────────────────┬───────────────────────┬──────────────┬────────────┬────────────────────┬─────────────┬──────────────┬────────────────────┐");
            System.out.println("│ ID  │ Name               │ Email                 │ Phone        │ Department │ Designation        │ Salary      │ Hire Date    │ Address            │");
            System.out.println("├─────┼────────────────────┼───────────────────────┼──────────────┼────────────┼────────────────────┼─────────────┼──────────────┼────────────────────┤");
            
            for (Employee emp : employees) {
                System.out.printf("│ %-4d│ %-19s│ %-22s│ %-13s│ %-11s│ %-19s│ %-12.2f│ %-13s│ %-19s│\n",
                    emp.getEmpId(),
                    truncate(emp.getName(), 19),
                    truncate(emp.getEmail(), 22),
                    emp.getPhone() != null ? truncate(emp.getPhone(), 13) : "N/A",
                    truncate(emp.getDepartment(), 11),
                    truncate(emp.getDesignation(), 19),
                    emp.getSalary(),
                    emp.getHireDate() != null ? emp.getHireDate().toString() : "N/A",
                    truncate(emp.getAddress(), 19));
            }
            
            System.out.println("└─────┴────────────────────┴───────────────────────┴──────────────┴────────────┴────────────────────┴─────────────┴──────────────┴────────────────────┘");
            System.out.println("Total Employees: " + employees.size());
            
        } catch (Exception e) {
            System.out.println("❌ Error: " + e.getMessage());
        }
    }
    
    private void searchEmployee() {
        System.out.println("\n--- SEARCH EMPLOYEE ---");
        System.out.println("1. Search by Employee ID");
        System.out.println("2. Search by Name");
        System.out.println("3. Search by Department");
        
        int choice = getIntInput("Choose search option: ", 1, 3);
        
        switch (choice) {
            case 1:
                int empId = getIntInput("Enter Employee ID: ");
                searchById(empId);
                break;
            case 2:
                String name = getStringInput("Enter Name (or part): ");
                searchByName(name);
                break;
            case 3:
                String dept = getStringInput("Enter Department: ");
                searchByDepartment(dept);
                break;
        }
    }
    
    private void searchById(int empId) {
        try {
            Employee emp = employeeService.getEmployeeById(empId);
            if (emp != null) {
                System.out.println("\n--- EMPLOYEE DETAILS ---");
                System.out.println(emp);
            } else {
                System.out.println("❌ No employee found with ID: " + empId);
            }
        } catch (Exception e) {
            System.out.println("❌ Error: " + e.getMessage());
        }
    }
    
    private void searchByName(String name) {
        try {
            List<Employee> employees = employeeService.searchEmployees("name", name);
            
            if (employees.isEmpty()) {
                System.out.println("❌ No employees found with name containing: " + name);
            } else {
                System.out.println("\nFound " + employees.size() + " employee(s):");
                for (Employee emp : employees) {
                    System.out.println("\n--- Employee Details ---");
                    System.out.println(emp);
                }
            }
        } catch (Exception e) {
            System.out.println("❌ Error: " + e.getMessage());
        }
    }
    
    private void searchByDepartment(String department) {
        try {
            List<Employee> employees = employeeService.searchEmployees("department", department);
            
            if (employees.isEmpty()) {
                System.out.println("❌ No employees found in department: " + department);
            } else {
                System.out.println("\nEmployees in " + department + " department:");
                System.out.println("─".repeat(60));
                for (Employee emp : employees) {
                    System.out.printf("%-4d %-20s %-15s $%-12.2f\n",
                        emp.getEmpId(),
                        truncate(emp.getName(), 20),
                        truncate(emp.getDesignation(), 15),
                        emp.getSalary());
                }
                System.out.println("─".repeat(60));
                System.out.println("Total: " + employees.size() + " employee(s)");
            }
        } catch (Exception e) {
            System.out.println("❌ Error: " + e.getMessage());
        }
    }
    
    private void updateEmployee() {
        System.out.println("\n--- UPDATE EMPLOYEE ---");
        int empId = getIntInput("Enter Employee ID to update: ");
        
        try {
            Employee existing = employeeService.getEmployeeById(empId);
            if (existing == null) {
                System.out.println("❌ Employee not found!");
                return;
            }
            
            System.out.println("\nCurrent Details:");
            System.out.println(existing);
            
            System.out.println("\nEnter new details (press Enter to keep current value):");
            
            String name = getStringInputWithDefault("Name [" + existing.getName() + "]: ", existing.getName());
            String email = getStringInputWithDefault("Email [" + existing.getEmail() + "]: ", existing.getEmail());
            String phone = getStringInputWithDefault("Phone [" + (existing.getPhone() != null ? existing.getPhone() : "N/A") + "]: ", existing.getPhone());
            String dept = getStringInputWithDefault("Department [" + existing.getDepartment() + "]: ", existing.getDepartment());
            String designation = getStringInputWithDefault("Designation [" + existing.getDesignation() + "]: ", existing.getDesignation());
            double salary = getDoubleInputWithDefault("Salary [" + existing.getSalary() + "]: ", existing.getSalary());
            String address = getStringInputWithDefault("Address [" + (existing.getAddress() != null ? existing.getAddress() : "N/A") + "]: ", existing.getAddress());
            
            Employee updated = new Employee(empId, name, email, phone, dept, designation, salary, existing.getHireDate(), address);
            
            if (employeeService.updateEmployee(updated)) {
                System.out.println("✅ Employee updated successfully!");
            }
            
        } catch (Exception e) {
            System.out.println("❌ Error: " + e.getMessage());
        }
    }
    
    private void deleteEmployee() {
        System.out.println("\n--- DELETE EMPLOYEE ---");
        int empId = getIntInput("Enter Employee ID to delete: ");
        
        try {
            Employee existing = employeeService.getEmployeeById(empId);
            if (existing == null) {
                System.out.println("❌ Employee not found!");
                return;
            }
            
            System.out.println("\nEmployee to be deleted:");
            System.out.println(existing);
            
            System.out.print("\nAre you sure you want to delete this employee? (yes/no): ");
            String confirm = scanner.nextLine().trim().toLowerCase();
            
            if (confirm.equals("yes") || confirm.equals("y")) {
                if (employeeService.deleteEmployee(empId)) {
                    System.out.println("✅ Employee deleted successfully!");
                }
            } else {
                System.out.println("Deletion cancelled.");
            }
            
        } catch (Exception e) {
            System.out.println("❌ Error: " + e.getMessage());
        }
    }
    
    private void viewDepartmentStats() {
        System.out.println("\n--- DEPARTMENT STATISTICS ---");
        
        try {
            List<EmployeeDAO.DepartmentStats> stats = employeeService.getDepartmentStatistics();
            
            if (stats.isEmpty()) {
                System.out.println("No department statistics available.");
                return;
            }
            
            System.out.println("┌────────────┬────────────┬──────────────┬──────────────┬──────────────┬──────────────┐");
            System.out.println("│ Department │ Employees  │ Avg Salary   │ Min Salary   │ Max Salary   │ Total Salary │");
            System.out.println("├────────────┼────────────┼──────────────┼──────────────┼──────────────┼──────────────┤");
            
            for (EmployeeDAO.DepartmentStats dept : stats) {
                System.out.printf("│ %-11s│ %-11d│ %-13.2f│ %-13.2f│ %-13.2f│ %-13.2f│\n",
                    dept.getDepartment(),
                    dept.getEmployeeCount(),
                    dept.getAvgSalary(),
                    dept.getMinSalary(),
                    dept.getMaxSalary(),
                    dept.getTotalSalary());
            }
            
            System.out.println("└────────────┴────────────┴──────────────┴──────────────┴──────────────┴──────────────┘");
            
        } catch (Exception e) {
            System.out.println("❌ Error: " + e.getMessage());
        }
    }
    
    private void viewCompanyStats() {
        System.out.println("\n--- COMPANY STATISTICS ---");
        
        try {
            EmployeeService.CompanyStats stats = employeeService.getCompanyStatistics();
            
            System.out.println("📊 COMPANY WIDE STATISTICS:");
            System.out.println("Total Employees: " + stats.getTotalEmployees());
            System.out.printf("Average Salary: $%.2f\n", stats.getAvgSalary());
            System.out.printf("Minimum Salary: $%.2f\n", stats.getMinSalary());
            System.out.printf("Maximum Salary: $%.2f\n", stats.getMaxSalary());
            System.out.printf("Total Salary Expense: $%.2f\n", stats.getTotalSalary());
            
        } catch (Exception e) {
            System.out.println("❌ Error: " + e.getMessage());
        }
    }
    
    // Utility methods
    private String truncate(String str, int length) {
        if (str == null) return "";
        return str.length() > length ? str.substring(0, length - 3) + "..." : str;
    }
    
    private int getIntInput(String prompt, int min, int max) {
        while (true) {
            try {
                System.out.print(prompt);
                int value = Integer.parseInt(scanner.nextLine().trim());
                if (value >= min && value <= max) {
                    return value;
                }
                System.out.println("Please enter a value between " + min + " and " + max);
            } catch (NumberFormatException e) {
                System.out.println("Invalid input! Please enter a valid number.");
            }
        }
    }
    
    private int getIntInput(String prompt) {
        while (true) {
            try {
                System.out.print(prompt);
                return Integer.parseInt(scanner.nextLine().trim());
            } catch (NumberFormatException e) {
                System.out.println("Invalid input! Please enter a valid number.");
            }
        }
    }
    
    private double getDoubleInput(String prompt) {
        while (true) {
            try {
                System.out.print(prompt);
                return Double.parseDouble(scanner.nextLine().trim());
            } catch (NumberFormatException e) {
                System.out.println("Invalid input! Please enter a valid number.");
            }
        }
    }
    
    private String getStringInput(String prompt) {
        System.out.print(prompt);
        return scanner.nextLine().trim();
    }
    
    private String getStringInputWithDefault(String prompt, String defaultValue) {
        System.out.print(prompt);
        String input = scanner.nextLine().trim();
        return input.isEmpty() ? defaultValue : input;
    }
    
    private double getDoubleInputWithDefault(String prompt, double defaultValue) {
        System.out.print(prompt);
        String input = scanner.nextLine().trim();
        if (input.isEmpty()) {
            return defaultValue;
        }
        try {
            return Double.parseDouble(input);
        } catch (NumberFormatException e) {
            System.out.println("Invalid input! Using default value.");
            return defaultValue;
        }
    }
    
    public void close() {
        scanner.close();
    }
}