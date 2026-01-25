package JDBC_Application_07.utils;

import java.util.regex.Pattern;

public class InputValidator {
    
    // Email validation regex
    private static final String EMAIL_REGEX = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$";
    private static final Pattern EMAIL_PATTERN = Pattern.compile(EMAIL_REGEX);
    
    // Phone validation regex (simple version)
    private static final String PHONE_REGEX = "^[0-9]{10}$";
    private static final Pattern PHONE_PATTERN = Pattern.compile(PHONE_REGEX);
    
    public static boolean isValidEmail(String email) {
        if (email == null || email.trim().isEmpty()) {
            return false;
        }
        return EMAIL_PATTERN.matcher(email).matches();
    }
    
    public static boolean isValidPhone(String phone) {
        if (phone == null || phone.trim().isEmpty()) {
            return true; // Phone is optional
        }
        return PHONE_PATTERN.matcher(phone).matches();
    }
    
    public static boolean isValidName(String name) {
        return name != null && !name.trim().isEmpty() && name.length() <= 100;
    }
    
    public static boolean isValidSalary(double salary) {
        return salary >= 0;
    }
    
    public static boolean isValidId(int id) {
        return id > 0;
    }
    
    public static String sanitizeInput(String input) {
        if (input == null) {
            return "";
        }
        // Remove leading/trailing whitespace and escape special characters
        return input.trim()
                   .replace("'", "''")  // Escape single quotes for SQL
                   .replace("\"", "\\\"") // Escape double quotes
                   .replace(";", "")    // Remove semicolons to prevent SQL injection
                   .replace("--", "")   // Remove SQL comments
                   .replace("/*", "")   // Remove SQL block comments
                   .replace("*/", "");
    }
}