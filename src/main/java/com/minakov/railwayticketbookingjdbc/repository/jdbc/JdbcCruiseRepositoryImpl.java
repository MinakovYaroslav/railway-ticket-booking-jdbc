package com.minakov.railwayticketbookingjdbc.repository.jdbc;

import com.minakov.railwayticketbookingjdbc.model.Cruise;
import com.minakov.railwayticketbookingjdbc.model.Route;
import com.minakov.railwayticketbookingjdbc.model.Train;
import com.minakov.railwayticketbookingjdbc.repository.CruiseRepository;
import com.minakov.railwayticketbookingjdbc.repository.RouteRepository;
import com.minakov.railwayticketbookingjdbc.repository.TrainRepository;
import com.minakov.railwayticketbookingjdbc.util.DBConnectionUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class JdbcCruiseRepositoryImpl implements CruiseRepository {

    private RouteRepository routeRepository;
    private TrainRepository trainRepository;

    public JdbcCruiseRepositoryImpl() {
        this.routeRepository = new JdbcRouteRepositoryImpl();
        this.trainRepository = new JdbcTrainRepositoryImpl();
    }

    @Override
    public List<Cruise> findAll() {
        try (Connection connection = DBConnectionUtil.getConnection()) {
            List<Cruise> cruises = new ArrayList<>();
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM cruises");
            Cruise cruise;
            while (resultSet.next()) {
                cruise = new Cruise();
                cruise.setId(resultSet.getString("id"));
                Train train = trainRepository.findById(resultSet.getString("train_id"));
                Route route = routeRepository.findById(resultSet.getString("route_id"));
                cruise.setTrain(train);
                cruise.setRoute(route);
                cruises.add(cruise);
            }
            return cruises;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void delete(String s) {

    }

    @Override
    public Cruise findById(String id) {
        try (Connection connection = DBConnectionUtil.getConnection()) {
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM cruises WHERE id = ?");
            statement.setString(1, id);
            ResultSet resultSet = statement.executeQuery();
            Cruise cruise = null;
            while (resultSet.next()) {
                cruise = new Cruise();
                Train train = trainRepository.findById(resultSet.getString("train_id"));
                Route route = routeRepository.findById(resultSet.getString("route_id"));
                cruise.setId(resultSet.getString("id"));
                cruise.setTrain(train);
                cruise.setRoute(route);
            }
            return cruise;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Cruise create(Cruise cruise) {
        return null;
    }

    @Override
    public Cruise update(Cruise cruise) {
        return null;
    }
}
