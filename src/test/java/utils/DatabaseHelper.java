package utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class DatabaseHelper {

    public static void main(String[] args) {
        
        // Configuration for H2 Database in Oracle Compatibility Mode
        String dbUrl = "jdbc:h2:mem:automationdb;MODE=Oracle"; 
        String username = "sa"; 
        String password = "";   

        try {
            System.out.println("Initializing Virtual Oracle Database (H2)...");
            
            Connection conn = DriverManager.getConnection(dbUrl, username, password);
            System.out.println("Success! Database connected successfully. 🎉\n");

            Statement stmt = conn.createStatement();
            
            // --- ACTUAL QA DATABASE VALIDATION SCENARIO ---
            
            // Step 1: Creating a dummy table (Simulating SauceDemo Backend)
            System.out.println("Step 1: Creating 'USERS' table...");
            stmt.execute("CREATE TABLE users (id INT PRIMARY KEY, username VARCHAR(50), status VARCHAR(20))");
            
            // Step 2: Inserting the valid test data
            System.out.println("Step 2: Inserting 'standard_user' into database...");
            stmt.execute("INSERT INTO users (id, username, status) VALUES (1, 'standard_user', 'ACTIVE')");
            stmt.execute("INSERT INTO users (id, username, status) VALUES (2, 'problem_user', 'LOCKED')");
            
            // Step 3: Querying the data to verify (The core QA task)
            System.out.println("\n--- Fetching Data for Validation ---");
            ResultSet rs = stmt.executeQuery("SELECT * FROM users");

            while (rs.next()) {
                System.out.println("User ID: " + rs.getInt("id") + 
                                   " | Username: " + rs.getString("username") + 
                                   " | Account Status: " + rs.getString("status"));
            }
            System.out.println("------------------------------------\n");

            // Step 4: Closing the connection
            conn.close();
            System.out.println("Database connection closed gracefully.");

        } catch (Exception e) {
            System.out.println("Database Exception Occurred: " + e.getMessage());
        }
    }
}