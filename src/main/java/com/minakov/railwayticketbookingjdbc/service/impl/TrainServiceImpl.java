package com.minakov.railwayticketbookingjdbc.service.impl;

import com.minakov.railwayticketbookingjdbc.config.DatabaseConfiguration;
import com.minakov.railwayticketbookingjdbc.model.DatabaseAccessType;
import com.minakov.railwayticketbookingjdbc.model.Train;
import com.minakov.railwayticketbookingjdbc.repository.TrainRepository;
import com.minakov.railwayticketbookingjdbc.repository.hibernate.HibernateTrainRepositoryImpl;
import com.minakov.railwayticketbookingjdbc.repository.jdbc.JdbcTrainRepositoryImpl;
import com.minakov.railwayticketbookingjdbc.service.TrainService;

import java.util.List;

public class TrainServiceImpl implements TrainService {

    private TrainRepository repository;

    public TrainServiceImpl() {
        this.repository = getRepository();
    }

    @Override
    public Train findById(String id) {
        return repository.findById(id);
    }

    @Override
    public List<Train> findAll() {
        return repository.findAll();
    }

    private TrainRepository getRepository() {
        if (DatabaseConfiguration.PROPERTY.getType().equalsIgnoreCase(DatabaseAccessType.JDBC.get())) {
            return new JdbcTrainRepositoryImpl();
        } else if (DatabaseConfiguration.PROPERTY.getType().equalsIgnoreCase(DatabaseAccessType.HIBERNATE.get())) {
            return new HibernateTrainRepositoryImpl();
        } else {
            throw new RuntimeException("Connection type is invalid!");
        }
    }
}
