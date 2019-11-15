package com.minakov.railwayticketbookingjdbc.service.impl;

import com.minakov.railwayticketbookingjdbc.model.*;
import com.minakov.railwayticketbookingjdbc.repository.TicketRepository;
import com.minakov.railwayticketbookingjdbc.repository.jdbc.JdbcTicketRepositoryImpl;
import com.minakov.railwayticketbookingjdbc.service.TicketService;
import com.minakov.railwayticketbookingjdbc.service.WagonService;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Calendar;
import java.util.List;
import java.util.Random;

public class TicketServiceImpl implements TicketService {

    private TicketRepository ticketRepository;

    private WagonService wagonService;

    public TicketServiceImpl() {
        this.ticketRepository = new JdbcTicketRepositoryImpl();
        this.wagonService = new WagonServiceImpl();
    }

    @Override
    public Ticket findById(String id) {
        return ticketRepository.findById(id);
    }

    @Override
    public List<Ticket> findAll() {
        return ticketRepository.findAll();
    }

    @Override
    public Ticket create(Ticket ticket) throws Exception {
        Train train;
        Wagon wagon;
        BigDecimal price;
        Timestamp orderDate;

        WagonType seatType = ticket.getSeatType();
        train = ticket.getCruise().getTrain();
        wagon = train.getWagons().stream()
                .filter(w -> w.getType().equals(seatType))
                .findFirst()
                .orElseThrow(() -> new Exception("Wagon with type " + seatType + " not found"));

        if (wagon.getTotalSeatsNumber() - wagon.getOccupiedSeatNumber() <= 0) {
            throw new Exception("No tickets available!");
        }

        wagon.setOccupiedSeatNumber(wagon.getOccupiedSeatNumber() + 1);
        wagonService.update(wagon);

        price = BigDecimal.valueOf(new Random().nextInt(500)); // Random price
        orderDate = new Timestamp(Calendar.getInstance().getTime().getTime()); // Current date

        ticket.setPrice(price);
        ticket.setOrderDate(orderDate);
        ticket.setStatus(TicketStatus.ACTIVE);

        return ticketRepository.create(ticket);
    }

    @Override
    public Ticket update(Ticket ticket) throws Exception {
        Cruise cruise = ticket.getCruise();
        Train train = cruise.getTrain();
        Wagon wagon = train.getWagons().stream()
                .filter(w -> w.getType().equals(ticket.getSeatType()))
                .findFirst()
                .orElseThrow(() -> new Exception("Wagon with type " + ticket.getSeatType() + " not found"));
        ticket.setStatus(TicketStatus.RETURNED);
        ticket.setReturnDate(new Timestamp(Calendar.getInstance().getTime().getTime()));
        wagon.setOccupiedSeatNumber(wagon.getOccupiedSeatNumber() - 1);
        wagonService.update(wagon);
        ticketRepository.update(ticket);
        return ticket;
    }
}
