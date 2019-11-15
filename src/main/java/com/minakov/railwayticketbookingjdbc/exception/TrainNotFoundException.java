package com.minakov.railwayticketbookingjdbc.exception;

public class TrainNotFoundException extends Throwable {

    private String trainId;

    public TrainNotFoundException(String trainId) {
        this.trainId = trainId;
    }

    @Override
    public String toString() {
        return "Train with id " + trainId + " not found";
    }
}
