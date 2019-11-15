package com.minakov.railwayticketbookingjdbc.config;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public enum DBProperties {

    CONNECTION;

    private final Properties properties;

    DBProperties() {
        properties = new Properties();
        try (InputStream is = new FileInputStream("src/main/resources/database.properties")) {
            properties.load(is);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String getUrl() {
        return properties.getProperty("db.url");
    }

    public String getLogin() {
        return properties.getProperty("db.login");
    }

    public String getPassword() {
        return properties.getProperty("db.password");
    }

    public String getDriver() {
        return properties.getProperty("db.driver");
    }
}
