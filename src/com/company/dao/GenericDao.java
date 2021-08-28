package com.company.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public abstract class GenericDao {
    protected final String connectionUrl = "your url";
    protected final String user = "user";
    protected final String password= "password";

    protected Connection getConnection() throws SQLException {
        return DriverManager.getConnection(connectionUrl,user,password);
    }

}
