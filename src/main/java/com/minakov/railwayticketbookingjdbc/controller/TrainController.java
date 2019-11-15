package com.minakov.railwayticketbookingjdbc.controller;

import com.minakov.railwayticketbookingjdbc.exception.TrainNotFoundException;
import com.minakov.railwayticketbookingjdbc.model.Train;
import com.minakov.railwayticketbookingjdbc.service.TrainService;
import com.minakov.railwayticketbookingjdbc.service.impl.TrainServiceImpl;

import java.util.List;

public class TrainController {

    private TrainService trainService;

    public TrainController() {
        this.trainService = new TrainServiceImpl();
    }

    public Train findById(String id) throws TrainNotFoundException {
        Train train = trainService.findById(id);
        if (train == null) {
            throw new TrainNotFoundException(id);
        }
        return train;
    }

    public List<Train> findAll() {
        return trainService.findAll();
    }
}
