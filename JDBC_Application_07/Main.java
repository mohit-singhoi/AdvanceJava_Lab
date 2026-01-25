package JDBC_Application_07;

public class Main {
    public static void main(String[] args) {
        EmployeeUI ui = null;
        
        try {
            // Initialize database connection
            if (!DatabaseConnection.testConnection()) {
                System.out.println("❌ Cannot connect to database. Please check your connection settings.");
                return;
            }
            
            // Initialize UI
            ui = new EmployeeUI();
            ui.displayMainMenu();
            
            // Initialize database tables
            EmployeeService service = new EmployeeService();
            service.initializeDatabase();
            
            // Main application loop
            boolean exit = false;
            while (!exit) {
                int choice = ui.showMenuAndGetChoice();
                
                if (choice == 8) {
                    exit = true;
                } else {
                    ui.handleChoice(choice);
                }
            }
            
        } catch (Exception e) {
            System.out.println("❌ An unexpected error occurred: " + e.getMessage());
            e.printStackTrace();
        } finally {
            // Clean up resources
            if (ui != null) {
                ui.close();
            }
            DatabaseConnection.closeConnection();
            System.out.println("\nApplication terminated.");
        }
    }
}