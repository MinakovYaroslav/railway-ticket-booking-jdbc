package com.minakov.railwayticketbookingjdbc.service.impl;

import com.minakov.railwayticketbookingjdbc.model.Station;
import com.minakov.railwayticketbookingjdbc.repository.StationRepository;
import com.minakov.railwayticketbookingjdbc.repository.jdbc.JdbcStationRepositoryImpl;
import com.minakov.railwayticketbookingjdbc.service.StationService;

import java.util.List;

public class StationServiceImpl implements StationService {

    private StationRepository repository;

    public StationServiceImpl() {
        this.repository = new JdbcStationRepositoryImpl();
    }

    @Override
    public Station findById(String id) {
        return repository.findById(id);
    }

    @Override
    public List<Station> findAll() {
        return repository.findAll();
    }
}
