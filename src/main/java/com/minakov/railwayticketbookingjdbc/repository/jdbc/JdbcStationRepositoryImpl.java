package com.minakov.railwayticketbookingjdbc.repository.jdbc;

import com.minakov.railwayticketbookingjdbc.model.Station;
import com.minakov.railwayticketbookingjdbc.repository.StationRepository;
import com.minakov.railwayticketbookingjdbc.util.DBConnectionUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class JdbcStationRepositoryImpl implements StationRepository {

    @Override
    public List<Station> findAll() {
        return null;
    }

    @Override
    public void delete(String s) {

    }

    @Override
    public Station findById(String id) {
        try (Connection connection = DBConnectionUtil.getConnection()){
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM stations WHERE id = ?");
            statement.setString(1, id);
            ResultSet resultSet = statement.executeQuery();
            Station station = null;
            while (resultSet.next()) {
                station = new Station();
                station.setId(resultSet.getString("id"));
                station.setName(resultSet.getString("name"));
            }
            return station;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Station create(Station station) {
        return null;
    }

    @Override
    public Station update(Station station) {
        return null;
    }
}
