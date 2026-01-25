package JDBC_Application_07.utils;

import JDBC_Application_07.Employee;
import java.util.List;

public class TableFormatter {
    
    public static void displayEmployeeTable(List<Employee> employees) {
        if (employees == null || employees.isEmpty()) {
            System.out.println("No employees to display.");
            return;
        }
        
        // Table headers
        String[] headers = {"ID", "Name", "Email", "Phone", "Department", "Designation", "Salary", "Hire Date"};
        int[] widths = {5, 20, 25, 15, 15, 20, 12, 15};
        
        // Print top border
        printHorizontalBorder(widths);
        
        // Print headers
        printRow(headers, widths);
        
        // Print separator
        printHorizontalBorder(widths);
        
        // Print data rows
        for (Employee emp : employees) {
            String[] row = {
                String.valueOf(emp.getEmpId()),
                truncate(emp.getName(), widths[1] - 2),
                truncate(emp.getEmail(), widths[2] - 2),
                emp.getPhone() != null ? truncate(emp.getPhone(), widths[3] - 2) : "N/A",
                truncate(emp.getDepartment(), widths[4] - 2),
                truncate(emp.getDesignation(), widths[5] - 2),
                String.format("$%.2f", emp.getSalary()),
                emp.getHireDate() != null ? emp.getHireDate().toString() : "N/A"
            };
            printRow(row, widths);
        }
        
        // Print bottom border
        printHorizontalBorder(widths);
        System.out.println("Total Employees: " + employees.size());
    }
    
    private static void printHorizontalBorder(int[] widths) {
        System.out.print("+");
        for (int width : widths) {
            System.out.print("-".repeat(width) + "+");
        }
        System.out.println();
    }
    
    private static void printRow(String[] values, int[] widths) {
        System.out.print("|");
        for (int i = 0; i < values.length; i++) {
            System.out.printf(" %-" + (widths[i] - 2) + "s |", values[i]);
        }
        System.out.println();
    }
    
    private static String truncate(String str, int maxLength) {
        if (str == null) return "";
        return str.length() > maxLength ? str.substring(0, maxLength - 3) + "..." : str;
    }
    
    public static void displayMessageBox(String title, String message) {
        int width = Math.max(title.length(), message.length()) + 4;
        
        System.out.println("+" + "-".repeat(width) + "+");
        System.out.println("| " + centerText(title, width - 2) + " |");
        System.out.println("+" + "-".repeat(width) + "+");
        System.out.println("| " + centerText(message, width - 2) + " |");
        System.out.println("+" + "-".repeat(width) + "+");
    }
    
    private static String centerText(String text, int width) {
        if (text.length() >= width) {
            return text.substring(0, width);
        }
        
        int padding = width - text.length();
        int leftPadding = padding / 2;
        int rightPadding = padding - leftPadding;
        
        return " ".repeat(leftPadding) + text + " ".repeat(rightPadding);
    }
}