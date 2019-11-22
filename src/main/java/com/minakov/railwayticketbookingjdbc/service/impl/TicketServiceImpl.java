package com.minakov.railwayticketbookingjdbc.service.impl;

import com.minakov.railwayticketbookingjdbc.config.DatabaseConfiguration;
import com.minakov.railwayticketbookingjdbc.model.*;
import com.minakov.railwayticketbookingjdbc.repository.TicketRepository;
import com.minakov.railwayticketbookingjdbc.repository.hibernate.HibernateTicketRepositoryImpl;
import com.minakov.railwayticketbookingjdbc.repository.jdbc.JdbcTicketRepositoryImpl;
import com.minakov.railwayticketbookingjdbc.service.CruiseService;
import com.minakov.railwayticketbookingjdbc.service.TicketService;
import com.minakov.railwayticketbookingjdbc.service.TrainService;
import com.minakov.railwayticketbookingjdbc.service.WagonService;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Calendar;
import java.util.List;
import java.util.Random;

public class TicketServiceImpl implements TicketService {

    private TicketRepository ticketRepository;
    private TrainService trainService;
    private WagonService wagonService;
    private CruiseService cruiseService;

    public TicketServiceImpl() {
        this.ticketRepository = getRepository();
        this.wagonService = new WagonServiceImpl();
        this.trainService = new TrainServiceImpl();
        this.cruiseService = new CruiseServiceImpl();
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

        // Search train
        train = trainService.findById(ticket.getCruise().getTrain().getId());

        // Search available seats
        wagon = train.getWagons().stream()
                .filter(w -> w.getType().equals(seatType) && (w.getTotalSeatsNumber() - w.getOccupiedSeatNumber()) > 0)
                .findFirst()
                .orElseThrow(() -> new Exception("No available seats!"));

        wagon.setOccupiedSeatNumber(wagon.getOccupiedSeatNumber() + 1);
        wagonService.update(wagon);

        // Random price
        price = BigDecimal.valueOf(new Random().nextInt(500));

        // Current date
        orderDate = new Timestamp(Calendar.getInstance().getTime().getTime());

        ticket.setPrice(price);
        ticket.setOrderDate(orderDate);
        ticket.setStatus(TicketStatus.ACTIVE);

        return ticketRepository.create(ticket);
    }

    @Override
    public Ticket update(Ticket ticket) throws Exception {

        // Search cruise
        Cruise cruise = cruiseService.findById(ticket.getCruise().getId());

        // Search train
        Train train = trainService.findById(cruise.getTrain().getId());

        // Search wagon by ticket type
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

    private TicketRepository getRepository() {
        if (DatabaseConfiguration.PROPERTY.getType().equalsIgnoreCase(DatabaseAccessType.JDBC.get())) {
            return new JdbcTicketRepositoryImpl();
        } else if (DatabaseConfiguration.PROPERTY.getType().equalsIgnoreCase(DatabaseAccessType.HIBERNATE.get())) {
            return new HibernateTicketRepositoryImpl();
        } else {
            throw new RuntimeException("Connection type is invalid!");
        }
    }
}
