package com.minakov.railwayticketbookingjdbc.model;

public class Station extends AbstractIdentifiable {

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
