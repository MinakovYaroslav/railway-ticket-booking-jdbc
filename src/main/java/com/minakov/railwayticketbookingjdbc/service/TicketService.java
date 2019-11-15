package com.minakov.railwayticketbookingjdbc.service;

import com.minakov.railwayticketbookingjdbc.model.Ticket;

import java.util.List;

public interface TicketService {

    Ticket findById(String id);

    List<Ticket> findAll();

    Ticket create(Ticket ticket) throws Exception;

    Ticket update(Ticket ticket) throws Exception;
}
