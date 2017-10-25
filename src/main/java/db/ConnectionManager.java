package db;

import org.apache.log4j.Logger;
import pojo.Answer;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionManager implements IConnectionManager{

    private static final ConnectionManager INSTANCE = new ConnectionManager();
    private Connection connection;
    private static final Logger logger = Logger.getLogger(ConnectionManager.class);

    private ConnectionManager() {
        try {
            Class.forName("org.postgresql.Driver");
            connection =
                    DriverManager.getConnection(
                            "jdbc:postgresql://localhost:5432/puzzles",
                            "postgres",
                            "root");
        } catch (SQLException e) {
           logger.error(e.getMessage());
        } catch (ClassNotFoundException e) {
            logger.error(e.getMessage());
        } catch (Exception e){
            logger.error(e.getMessage());
        }
    }

    public static synchronized ConnectionManager getInstance() {
        return INSTANCE;
    }

    public Connection getConnection() {
        return connection;
    }


}

