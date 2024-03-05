package src;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {

    public static final String URL = "jdbc:postgresql://localhost:5432/hausarzt_pt2_db";
    private static final String USER = "postgres";
    private static final String PASSWORD = "123456";

    public static Connection createConnection() {
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }

    public static void printConnectionInfo() {
        try (Connection connection = createConnection()) {
            if (connection != null) {
                System.out.println("Connection established");
            } else {
                System.out.println("Connection failed");
            }
        } catch (SQLException e) {
            System.err.format("SQL State: %s\n%s", e.getSQLState(), e.getMessage());
        }
    }

}
