package com.minakov.railwayticketbookingjdbc.model;

import java.math.BigDecimal;
import java.sql.Timestamp;

public class Ticket extends AbstractIdentifiable {

    private User user;

    private Cruise cruise;

    private WagonType seatType;

    private BigDecimal price;

    private Timestamp orderDate;

    private TicketStatus status;

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
