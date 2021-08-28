package com.company.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public abstract class GenericDao {
    protected final String connectionUrl = "jdbc:mysql://localhost:3306/carRental";
    protected final String user = "root";
    protected final String password= "victor";

    protected Connection getConnection() throws SQLException {
        return DriverManager.getConnection(connectionUrl,user,password);
    }

}
