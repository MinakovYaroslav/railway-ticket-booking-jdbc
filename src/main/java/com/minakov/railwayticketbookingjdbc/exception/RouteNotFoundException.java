package com.minakov.railwayticketbookingjdbc.exception;

public class RouteNotFoundException extends Throwable {

    private String routeId;

    public RouteNotFoundException(String routeId) {
        this.routeId = routeId;
    }

    @Override
    public String toString() {
        return "Route with id " + routeId + " not found";
    }
}
