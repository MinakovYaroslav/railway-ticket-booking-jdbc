package com.minakov.railwayticketbookingjdbc.exception;

public class WagonNotFoundException extends Throwable {

    private String message;

    public WagonNotFoundException(String wagonId) {
        this.message = "Wagon with id " + wagonId + " not found";
    }

    @Override
    public String toString() {
        return message;
    }
}
