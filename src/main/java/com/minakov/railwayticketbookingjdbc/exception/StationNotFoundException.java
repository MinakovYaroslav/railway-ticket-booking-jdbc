package com.minakov.railwayticketbookingjdbc.exception;

public class StationNotFoundException extends Throwable {

    private String stationId;

    public StationNotFoundException(String stationId) {
        this.stationId = stationId;
    }

    @Override
    public String toString() {
        return "Station with id " + stationId + " not found";
    }
}
