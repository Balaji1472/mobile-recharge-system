package com.recharge.config;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;


public final class DBConnection {

    private static String URL;
    private static String USERNAME;
    private static String PASSWORD;
    private static String DRIVER;
    
    private static Connection connection;

    // static block runs once when class is loaded
    static {
        try (InputStream input = DBConnection.class.getClassLoader().getResourceAsStream("application.properties")) {

            if (input == null) {
                throw new RuntimeException("application.properties not found");
            }

            Properties props = new Properties();
            props.load(input);

            URL = props.getProperty("db.url");
            USERNAME = props.getProperty("db.username");
            PASSWORD = props.getProperty("db.password");
            DRIVER = props.getProperty("db.driver");

            Class.forName(DRIVER);
            System.out.println("DB Driver Loaded: "+ DRIVER);

        } catch (Exception e) {
            throw new RuntimeException("Failed to load DB configuration", e);
        }
    }

    private DBConnection() {
        // prevent instantiation
    }

    //initialize single shared connection
    public static void initialize() {
    	try {
    		if(connection == null || connection.isClosed()) {
    			connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
    			System.out.println("Database connections established successfully");
    		}
    	}
    	catch(SQLException e) {
    		throw new RuntimeException("Failed to establish the DB connection", e);
    	}
    }
    
    public static Connection getConnection() throws SQLException {
    	if(connection == null) {
    		throw new IllegalStateException("DB not initialized. Call initialized() first");
    	}
        return connection;
    }
    
    //shutdown the connection
    public static void close() {
    	try {
    		if(connection != null && !connection.isClosed()) {
    			connection.close();
    			System.out.println("DB connection closed");
    		}
    	}
    	catch(SQLException e) {
    		e.printStackTrace();
    	}
    }
}
