package com.minakov.railwayticketbookingjdbc.service;

import com.minakov.railwayticketbookingjdbc.model.Cruise;

import java.util.List;

public interface CruiseService {

    Cruise findById(String id);

    List<Cruise> findAll();
}
