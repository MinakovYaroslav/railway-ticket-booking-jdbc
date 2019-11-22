package com.minakov.railwayticketbookingjdbc.model;

public enum DatabaseAccessType {

    JDBC("jdbc"), HIBERNATE("hibernate");

    private final String accessType;

    DatabaseAccessType(String accessType) {
        this.accessType = accessType;
    }

    public String get() {
        return accessType;
    }
}
