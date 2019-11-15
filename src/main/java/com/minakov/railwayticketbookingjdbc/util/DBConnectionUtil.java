package com.minakov.railwayticketbookingjdbc.util;

import com.minakov.railwayticketbookingjdbc.config.DBProperties;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnectionUtil {

    public static Connection getConnection() {
        try {
            Class.forName(DBProperties.CONNECTION.getDriver());
            return DriverManager.getConnection(DBProperties.CONNECTION.getUrl(),
                    DBProperties.CONNECTION.getLogin(),
                    DBProperties.CONNECTION.getPassword());
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
