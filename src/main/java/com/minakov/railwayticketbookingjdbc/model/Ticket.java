package com.minakov.railwayticketbookingjdbc.model;

import javax.persistence.*;
import java.math.BigDecimal;
import java.sql.Timestamp;

@Entity
@Table(name = "tickets")
public class Ticket extends AbstractIdentifiable {

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "cruise_id")
    private Cruise cruise;

    @Enumerated(EnumType.STRING)
    @Column(name = "seat_type")
    private WagonType seatType;

    @Column(name = "price")
    private BigDecimal price;

    @Column(name = "order_date")
    private Timestamp orderDate;

    @Enumerated(EnumType.STRING)
    @Column(name = "status")
    private TicketStatus status;

    @Column(name = "return_date")
    private Timestamp returnDate;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Cruise getCruise() {
        return cruise;
    }

    public void setCruise(Cruise cruise) {
        this.cruise = cruise;
    }

    public WagonType getSeatType() {
        return seatType;
    }

    public void setSeatType(WagonType seatType) {
        this.seatType = seatType;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Timestamp getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Timestamp orderDate) {
        this.orderDate = orderDate;
    }

    public TicketStatus getStatus() {
        return status;
    }

    public void setStatus(TicketStatus status) {
        this.status = status;
    }

    public Timestamp getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(Timestamp returnDate) {
        this.returnDate = returnDate;
    }
}
