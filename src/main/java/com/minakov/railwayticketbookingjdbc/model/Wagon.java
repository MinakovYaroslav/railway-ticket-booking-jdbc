package com.minakov.railwayticketbookingjdbc.model;

public class Wagon extends AbstractIdentifiable {

    private int totalSeatsNumber;

    private int occupiedSeatNumber;

    private WagonType type;

    public int getTotalSeatsNumber() {
        return totalSeatsNumber;
    }

    public void setTotalSeatsNumber(int totalSeatsNumber) {
        this.totalSeatsNumber = totalSeatsNumber;
    }

    public int getOccupiedSeatNumber() {
        return occupiedSeatNumber;
    }

    public void setOccupiedSeatNumber(int occupiedSeatNumber) {
        this.occupiedSeatNumber = occupiedSeatNumber;
    }

    public WagonType getType() {
        return type;
    }

    public void setType(WagonType type) {
        this.type = type;
    }
}
