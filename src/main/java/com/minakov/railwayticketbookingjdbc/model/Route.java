package com.minakov.railwayticketbookingjdbc.model;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "routes")
public class Route extends AbstractIdentifiable {

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "origin_station_id")
    private Station origin;

    @Column(name = "departure_date")
    private Timestamp departureDate;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "destination_station_id")
    private Station destination;

    @Column(name = "arrival_date")
    private Timestamp arrivalDate;

    public Station getOrigin() {
        return origin;
    }

    public void setOrigin(Station origin) {
        this.origin = origin;
    }

    public Timestamp getDepartureDate() {
        return departureDate;
    }

    public void setDepartureDate(Timestamp departureDate) {
        this.departureDate = departureDate;
    }

    public Station getDestination() {
        return destination;
    }

    public void setDestination(Station destination) {
        this.destination = destination;
    }

    public Timestamp getArrivalDate() {
        return arrivalDate;
    }

    public void setArrivalDate(Timestamp arrivalDate) {
        this.arrivalDate = arrivalDate;
    }
}
