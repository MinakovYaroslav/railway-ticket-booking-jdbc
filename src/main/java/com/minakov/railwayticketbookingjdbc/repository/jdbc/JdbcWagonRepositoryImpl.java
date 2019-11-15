package com.minakov.railwayticketbookingjdbc.repository.jdbc;

import com.minakov.railwayticketbookingjdbc.model.Wagon;
import com.minakov.railwayticketbookingjdbc.model.WagonType;
import com.minakov.railwayticketbookingjdbc.repository.WagonRepository;
import com.minakov.railwayticketbookingjdbc.util.DBConnectionUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class JdbcWagonRepositoryImpl implements WagonRepository {

    @Override
    public List<Wagon> findAll() {
        return null;
    }

    @Override
    public void delete(String s) {

    }

    @Override
    public Wagon findById(String id) {
        try (Connection connection = DBConnectionUtil.getConnection()) {
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM wagons WHERE id = ?");
            statement.setString(1, id);
            ResultSet resultSet = statement.executeQuery();
            Wagon wagon = null;
            while (resultSet.next()) {
                wagon = new Wagon();
                wagon.setId(resultSet.getString("id"));
                wagon.setTotalSeatsNumber(resultSet.getInt("total_seats_number"));
                wagon.setOccupiedSeatNumber(resultSet.getInt("occupied_seat_number"));
                wagon.setType(WagonType.valueOf(resultSet.getString("type")));
            }
            return wagon;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Wagon create(Wagon wagon) {
        return null;
    }

    @Override
    public Wagon update(Wagon wagon) {
        try (Connection connection = DBConnectionUtil.getConnection()) {
            PreparedStatement statement = connection.prepareStatement("UPDATE wagons SET total_seats_number = ?, occupied_seat_number = ? WHERE id = ?");
            statement.setInt(1, wagon.getTotalSeatsNumber());
            statement.setInt(2, wagon.getOccupiedSeatNumber());
            statement.setString(3, wagon.getId());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return wagon;
    }
}
