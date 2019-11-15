package com.minakov.railwayticketbookingjdbc.controller;

import com.minakov.railwayticketbookingjdbc.exception.TicketNotFoundException;
import com.minakov.railwayticketbookingjdbc.model.Cruise;
import com.minakov.railwayticketbookingjdbc.model.Ticket;
import com.minakov.railwayticketbookingjdbc.model.User;
import com.minakov.railwayticketbookingjdbc.model.WagonType;
import com.minakov.railwayticketbookingjdbc.service.TicketService;
import com.minakov.railwayticketbookingjdbc.service.impl.TicketServiceImpl;

import java.util.List;

public class TicketController {

    private TicketService ticketService;

    public TicketController() {
        this.ticketService = new TicketServiceImpl();
    }

    public Ticket findById(String id) throws TicketNotFoundException {
        Ticket ticket = ticketService.findById(id);
        if (ticket == null) {
            throw new TicketNotFoundException(id);
        }
        return ticket;
    }

    public List<Ticket> findAll() {
        return ticketService.findAll();
    }

    public Ticket create(Ticket ticket) throws Exception {
        return ticketService.create(ticket);
    }

    public Ticket update(Ticket ticket) throws Exception {
        return ticketService.update(ticket);
    }

    public Ticket create(User user, Cruise cruise, WagonType wagonType) throws Exception {
        Ticket ticket = new Ticket();
        ticket.setUser(user);
        ticket.setCruise(cruise);
        ticket.setSeatType(wagonType);
        return ticketService.create(ticket);
    }
}