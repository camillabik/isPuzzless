package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionManager implements IConnectionManager{

    private static final ConnectionManager INSTANCE = new ConnectionManager();
    private Connection connection;

    private ConnectionManager() {
        try {
            Class.forName("org.postgresql.Driver");
            connection =
                    DriverManager.getConnection(
                            "jdbc:postgresql://localhost:5432/puzzles",
                            "postgres",
                            "root");
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static synchronized ConnectionManager getInstance() {
        return INSTANCE;
    }

    public Connection getConnection() {
        return connection;
    }


}

