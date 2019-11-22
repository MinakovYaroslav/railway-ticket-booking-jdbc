package com.minakov.railwayticketbookingjdbc.repository.jdbc;

import com.minakov.railwayticketbookingjdbc.model.Train;
import com.minakov.railwayticketbookingjdbc.model.Wagon;
import com.minakov.railwayticketbookingjdbc.repository.TrainRepository;
import com.minakov.railwayticketbookingjdbc.repository.WagonRepository;
import com.minakov.railwayticketbookingjdbc.util.JDBCUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class JdbcTrainRepositoryImpl implements TrainRepository {

    private WagonRepository wagonRepository;

    public JdbcTrainRepositoryImpl() {
        this.wagonRepository = new JdbcWagonRepositoryImpl();
    }

    @Override
    public List<Train> findAll() {
        return null;
    }

    @Override
    public void delete(String s) {

    }

    @Override
    public Train findById(String id) {
        try (Connection connection = JDBCUtil.getConnection()) {
            PreparedStatement statement1 = connection.prepareStatement("SELECT * FROM trains WHERE id = ?");
            PreparedStatement statement2 = connection.prepareStatement("SELECT wagon_id FROM train_wagons WHERE train_id = ?");
            statement1.setString(1, id);
            statement2.setString(1, id);
            ResultSet resultSet1 = statement1.executeQuery();
            ResultSet resultSet2 = statement2.executeQuery();
            Train train = null;
            List<Wagon> wagons;
            while (resultSet1.next()) {
                train = new Train();
                wagons = new ArrayList<>();
                train.setId(resultSet1.getString("id"));
                while (resultSet2.next()) {
                    Wagon wagon = wagonRepository.findById(resultSet2.getString("wagon_id"));
                    wagons.add(wagon);
                }
                train.setWagons(wagons);
            }
            return train;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Train create(Train train) {
        return null;
    }

    @Override
    public Train update(Train train) {
        return null;
    }
}
