package com.minakov.railwayticketbookingjdbc.exception;

public class TicketNotFoundException extends Throwable {

    private String message;

    public TicketNotFoundException(String ticketId) {
        this.message = "Ticket with id " + ticketId + " not found";
    }

    @Override
    public String toString() {
        return message;
    }
}
