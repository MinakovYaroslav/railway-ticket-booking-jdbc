package com.minakov.railwayticketbookingjdbc.view;

import com.minakov.railwayticketbookingjdbc.controller.TicketController;
import com.minakov.railwayticketbookingjdbc.exception.TicketNotFoundException;
import com.minakov.railwayticketbookingjdbc.io.Console;
import com.minakov.railwayticketbookingjdbc.model.Ticket;

public class TicketReturnView extends ViewTemplate {

    private TicketController ticketController;

    public TicketReturnView() {
        this.ticketController = new TicketController();
        content();
    }

    @Override
    public void content() {
        String line;
        String id;
        Ticket ticket;
        System.out.println("Enter ticket id: ");
        line = Console.input();
        id = line;
        try {
            ticket = ticketController.findById(id);
            ticketController.update(ticket);
            System.out.println("Ticket returned!");
        } catch (TicketNotFoundException e) {
            e.printStackTrace();
        } catch (Exception e) {
            System.err.println(e.getMessage());
            e.printStackTrace();
        }
    }
}
