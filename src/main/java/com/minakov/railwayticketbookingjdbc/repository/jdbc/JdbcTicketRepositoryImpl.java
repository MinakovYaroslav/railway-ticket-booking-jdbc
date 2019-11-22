package com.minakov.railwayticketbookingjdbc.repository.jdbc;

import com.minakov.railwayticketbookingjdbc.model.*;
import com.minakov.railwayticketbookingjdbc.repository.TicketRepository;
import com.minakov.railwayticketbookingjdbc.repository.UserRepository;
import com.minakov.railwayticketbookingjdbc.util.JDBCUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Calendar;
import java.util.List;
import java.util.UUID;

public class JdbcTicketRepositoryImpl implements TicketRepository {

    private UserRepository userRepository;

    public JdbcTicketRepositoryImpl() {
        this.userRepository = new JdbcUserRepositoryImpl();
    }

    @Override
    public List<Ticket> findAll() {
        return null;
    }

    @Override
    public void delete(String s) {

    }

    @Override
    public Ticket findById(String id) {
        try (Connection connection = JDBCUtil.getConnection()) {
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM tickets WHERE id = ?");
            statement.setString(1, id);
            ResultSet resultSet = statement.executeQuery();
            Ticket ticket = null;
            while (resultSet.next()) {
                ticket = new Ticket();
                User user = userRepository.findById(resultSet.getString("user_id"));
                Cruise cruise = new Cruise();
                cruise.setId(resultSet.getString("cruise_id"));
                ticket.setId(resultSet.getString("id"));
                ticket.setCruise(cruise);
                ticket.setUser(user);
                ticket.setSeatType(WagonType.valueOf(resultSet.getString("seat_type")));
                ticket.setPrice(resultSet.getBigDecimal("price"));
                ticket.setStatus(TicketStatus.valueOf(resultSet.getString("status")));
                ticket.setOrderDate(resultSet.getTimestamp("order_date"));
                ticket.setReturnDate(resultSet.getTimestamp("return_date"));
            }
            return ticket;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Ticket create(Ticket ticket) {

        ticket.setId(UUID.randomUUID().toString());

        try (Connection connection = JDBCUtil.getConnection()) {
            PreparedStatement statement = connection.prepareStatement("INSERT INTO tickets VALUES (?, ?, ?, ?, ?, ?, ?, ?)");
            statement.setString(1, ticket.getId());
            statement.setString(2, ticket.getUser().getId());
            statement.setString(3, ticket.getCruise().getId());
            statement.setString(4, ticket.getSeatType().toString());
            statement.setBigDecimal(5, ticket.getPrice());
            statement.setTimestamp(6, ticket.getOrderDate(), Calendar.getInstance());
            statement.setString(7, ticket.getStatus().toString());
            statement.setTimestamp(8, null);
            statement.executeUpdate();
            return ticket;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Ticket update(Ticket ticket) {
        try (Connection connection = JDBCUtil.getConnection()) {
            PreparedStatement statement = connection.prepareStatement("UPDATE tickets SET status = ?, return_date = ? WHERE id = ?");
            statement.setString(1, ticket.getStatus().toString());
            statement.setTimestamp(2, ticket.getReturnDate(), Calendar.getInstance());
            statement.setString(3, ticket.getId());
            statement.executeUpdate();
            return ticket;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
