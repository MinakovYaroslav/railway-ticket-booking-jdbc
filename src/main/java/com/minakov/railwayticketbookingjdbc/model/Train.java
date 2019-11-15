package com.minakov.railwayticketbookingjdbc.model;

import java.util.List;

public class Train extends AbstractIdentifiable {

    private List<Wagon> wagons;

    public List<Wagon> getWagons() {
        return wagons;
    }

    public void setWagons(List<Wagon> wagons) {
        this.wagons = wagons;
    }
}
