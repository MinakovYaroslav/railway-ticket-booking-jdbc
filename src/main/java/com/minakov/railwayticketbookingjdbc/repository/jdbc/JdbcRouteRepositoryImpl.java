package com.minakov.railwayticketbookingjdbc.repository.jdbc;

import com.minakov.railwayticketbookingjdbc.model.Route;
import com.minakov.railwayticketbookingjdbc.model.Station;
import com.minakov.railwayticketbookingjdbc.repository.RouteRepository;
import com.minakov.railwayticketbookingjdbc.repository.StationRepository;
import com.minakov.railwayticketbookingjdbc.util.DBConnectionUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class JdbcRouteRepositoryImpl implements RouteRepository {

    private StationRepository stationRepository;

    public JdbcRouteRepositoryImpl() {
        this.stationRepository = new JdbcStationRepositoryImpl();
    }

    @Override
    public List<Route> findAll() {
        return null;
    }

    @Override
    public void delete(String s) {

    }

    @Override
    public Route findById(String id) {
        try (Connection connection = DBConnectionUtil.getConnection()) {
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM routes WHERE id = ?");
            statement.setString(1, id);
            ResultSet resultSet = statement.executeQuery();
            Route route = null;
            while (resultSet.next()) {
                route = new Route();
                Station origin = stationRepository.findById(resultSet.getString("origin_station_id"));
                Station destination = stationRepository.findById(resultSet.getString("destination_station_id"));
                route.setId(resultSet.getString("id"));
                route.setOrigin(origin);
                route.setDepartureDate(resultSet.getTimestamp("departure_date"));
                route.setDestination(destination);
                route.setArrivalDate(resultSet.getTimestamp("arrival_date"));
            }
            return route;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Route create(Route route) {
        return null;
    }

    @Override
    public Route update(Route route) {
        return null;
    }
}
