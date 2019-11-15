package com.minakov.railwayticketbookingjdbc.model;

public abstract class AbstractIdentifiable {

    private String id;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
