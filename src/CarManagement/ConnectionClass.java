package CarManagement;
import java.sql.*;

public class ConnectionClass {
    Connection con;
    Statement stm;
    
    ConnectionClass() {
        try {
            // Load the MySQL JDBC driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Establish the database connection
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/CMS", "root", "root");

            // Create a statement object
            stm = con.createStatement();
        } catch(ClassNotFoundException ex) {
            ex.printStackTrace();
        } catch(SQLException ex) {
            ex.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new ConnectionClass();
    }
}
