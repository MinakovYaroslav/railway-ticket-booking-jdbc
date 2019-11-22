package com.minakov.railwayticketbookingjdbc.model;

import javax.persistence.*;

@Entity
@Table(name = "wagons")
public class Wagon extends AbstractIdentifiable {

    @Column(name = "total_seats_number")
    private int totalSeatsNumber;

    @Column(name = "occupied_seat_number")
    private int occupiedSeatNumber;

    @Enumerated(EnumType.STRING)
    @Column(name = "type")
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
