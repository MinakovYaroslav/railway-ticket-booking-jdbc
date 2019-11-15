package com.minakov.railwayticketbookingjdbc.service;

import com.minakov.railwayticketbookingjdbc.model.Station;

import java.util.List;

public interface StationService {

    Station findById(String id);

    List<Station> findAll();
}
