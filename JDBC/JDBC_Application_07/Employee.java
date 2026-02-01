package JDBC_Application_07;

import java.util.Date;

public class Employee {
    private int empId;
    private String name;
    private String email;
    private String phone;
    private String department;
    private String designation;
    private double salary;
    private Date hireDate;
    private String address;
    
    // Default constructor
    public Employee() {}
    
    // Parameterized constructor
    public Employee(int empId, String name, String email, String phone, 
                   String department, String designation, double salary, 
                   Date hireDate, String address) {
        this.empId = empId;
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.department = department;
        this.designation = designation;
        this.salary = salary;
        this.hireDate = hireDate;
        this.address = address;
    }
    
    // Getters and Setters
    public int getEmpId() { return empId; }
    public void setEmpId(int empId) { this.empId = empId; }
    
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    
    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
    
    public String getPhone() { return phone; }
    public void setPhone(String phone) { this.phone = phone; }
    
    public String getDepartment() { return department; }
    public void setDepartment(String department) { this.department = department; }
    
    public String getDesignation() { return designation; }
    public void setDesignation(String designation) { this.designation = designation; }
    
    public double getSalary() { return salary; }
    public void setSalary(double salary) { this.salary = salary; }
    
    public Date getHireDate() { return hireDate; }
    public void setHireDate(Date hireDate) { this.hireDate = hireDate; }
    
    public String getAddress() { return address; }
    public void setAddress(String address) { this.address = address; }
    
    @Override
    public String toString() {
        return String.format("Employee ID: %d\nName: %s\nEmail: %s\nPhone: %s\n" +
                           "Department: %s\nDesignation: %s\nSalary: %.2f\n" +
                           "Hire Date: %s\nAddress: %s",
                           empId, name, email, phone, department, 
                           designation, salary, hireDate, address);
    }
}