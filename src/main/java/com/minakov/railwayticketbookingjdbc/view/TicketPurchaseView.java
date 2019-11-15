package com.minakov.railwayticketbookingjdbc.view;

import com.minakov.railwayticketbookingjdbc.controller.CruiseController;
import com.minakov.railwayticketbookingjdbc.controller.TicketController;
import com.minakov.railwayticketbookingjdbc.controller.UserController;
import com.minakov.railwayticketbookingjdbc.io.Console;
import com.minakov.railwayticketbookingjdbc.model.*;

import java.sql.Date;
import java.util.Map;
import java.util.Random;

import static com.minakov.railwayticketbookingjdbc.config.DateFormatConfig.dateFormat;
import static com.minakov.railwayticketbookingjdbc.config.DateFormatConfig.userBirthdayFormat;

public class TicketPurchaseView extends ViewTemplate {

    private CruiseController cruiseController;
    private TicketController ticketController;
    private UserController userController;

    public TicketPurchaseView() {
        this.cruiseController = new CruiseController();
        this.ticketController = new TicketController();
        this.userController = new UserController();
        content();
    }

    @Override
    public void content() {
        Map<Integer, Cruise> cruises = cruiseController.cruiseTable();
        String line;
        Integer cruiseNumber;
        Cruise cruise;
        WagonType wagonType;
        String firstName;
        String lastName;
        Date birthday;
        User user;
        Ticket ticket;

        try {
            for (Map.Entry<Integer, Cruise> entry : cruises.entrySet()) { //Show list of cruises

                Route route = entry.getValue().getRoute();
                Station origin = route.getOrigin();
                Station destination = route.getDestination();

                System.out.println("№" + entry.getKey() + " " + dateFormat.format(route.getDepartureDate()) + " " + origin.getName() +
                        " - " + destination.getName() + " " + dateFormat.format(route.getArrivalDate()));
                System.out.println("ECONOMY seat price: " + new Random().nextInt(100) + "$");
                System.out.println("BUSINESS seat price: " + new Random().nextInt(300) + "$");
                System.out.println("PREMIUM seat price: " + new Random().nextInt(500) + "$");
                System.out.println();
            }

            System.out.println("Enter cruise №: ");
            line = Console.input();
            cruiseNumber = Integer.valueOf(line);
            cruise = cruises.get(cruiseNumber);

            System.out.println("Enter ticket type: ");
            line = Console.input();
            wagonType = WagonType.valueOf(line.toUpperCase());

            System.out.println("Enter your first name: ");
            line = Console.input();
            firstName = line;

            System.out.println("Enter your last name: ");
            line = Console.input();
            lastName = line;

            System.out.println("Enter your birthday YYYY-MM-DD : ");
            line = Console.input();
            birthday = new Date(userBirthdayFormat.parse(line).getTime());

            user = userController.create(firstName, lastName, birthday);
            ticket = ticketController.create(user, cruise, wagonType);

            System.out.println("Purchasing complete!");
            System.out.println("Your ticket info: ");
            System.out.println("Ticket id: " + ticket.getId());
            System.out.println("First name: " + user.getFirstName());
            System.out.println("Last name: " + user.getLastName());
            System.out.println(dateFormat.format(cruise.getRoute().getDepartureDate()) + " " + cruise.getRoute().getOrigin().getName() +
                    " - " + cruise.getRoute().getOrigin().getName() + " " + dateFormat.format(cruise.getRoute().getArrivalDate()));
            System.out.println("Seat type: " + ticket.getSeatType());
            System.out.println("Price: " + ticket.getPrice() + "$");
            System.out.println("Order date: " + dateFormat.format(ticket.getOrderDate()));

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
