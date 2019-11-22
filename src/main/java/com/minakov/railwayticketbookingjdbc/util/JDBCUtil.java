package com.minakov.railwayticketbookingjdbc.util;

import com.minakov.railwayticketbookingjdbc.config.DatabaseConfiguration;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JDBCUtil {

    public static Connection getConnection() {
        try {
            Class.forName(DatabaseConfiguration.PROPERTY.getDriver());
            return DriverManager.getConnection(DatabaseConfiguration.PROPERTY.getUrl(),
                    DatabaseConfiguration.PROPERTY.getLogin(),
                    DatabaseConfiguration.PROPERTY.getPassword());
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
