package com.minakov.railwayticketbookingjdbc.exception;

public class CruiseNotFoundException extends Throwable {

    private String cruiseId;

    public CruiseNotFoundException(String cruiseId) {
        this.cruiseId = cruiseId;
    }

    @Override
    public String toString() {
        return "Cruise with id " + cruiseId + " not found";
    }
}
