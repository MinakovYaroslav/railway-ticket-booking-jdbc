package com.minakov.railwayticketbookingjdbc.service;

import com.minakov.railwayticketbookingjdbc.model.Train;

import java.util.List;

public interface TrainService {

    Train findById(String id);

    List<Train> findAll();
}
