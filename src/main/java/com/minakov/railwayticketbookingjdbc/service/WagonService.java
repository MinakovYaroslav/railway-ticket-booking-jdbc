package com.minakov.railwayticketbookingjdbc.service;

import com.minakov.railwayticketbookingjdbc.model.Wagon;

import java.util.List;

public interface WagonService {

    Wagon findById(String id);

    List<Wagon> findAll();

    Wagon update(Wagon wagon);
}
