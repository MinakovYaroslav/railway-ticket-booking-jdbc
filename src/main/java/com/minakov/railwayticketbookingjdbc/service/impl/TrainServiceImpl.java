package com.minakov.railwayticketbookingjdbc.service.impl;

import com.minakov.railwayticketbookingjdbc.model.Train;
import com.minakov.railwayticketbookingjdbc.repository.TrainRepository;
import com.minakov.railwayticketbookingjdbc.repository.jdbc.JdbcTrainRepositoryImpl;
import com.minakov.railwayticketbookingjdbc.service.TrainService;

import java.util.List;

public class TrainServiceImpl implements TrainService {

    private TrainRepository repository;

    public TrainServiceImpl() {
        this.repository = new JdbcTrainRepositoryImpl();
    }

    @Override
    public Train findById(String id) {
        return repository.findById(id);
    }

    @Override
    public List<Train> findAll() {
        return repository.findAll();
    }
}
