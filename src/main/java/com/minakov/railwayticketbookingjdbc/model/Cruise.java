package com.minakov.railwayticketbookingjdbc.model;

public class Cruise extends AbstractIdentifiable {

    private Route route;

    private Train train;

    public Route getRoute() {
        return route;
    }

    public void setRoute(Route route) {
        this.route = route;
    }

    public Train getTrain() {
        return train;
    }

    public void setTrain(Train train) {
        this.train = train;
    }
}
