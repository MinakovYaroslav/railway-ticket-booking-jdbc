package com.minakov.railwayticketbookingjdbc.service.impl;

import com.minakov.railwayticketbookingjdbc.model.Cruise;
import com.minakov.railwayticketbookingjdbc.repository.CruiseRepository;
import com.minakov.railwayticketbookingjdbc.repository.jdbc.JdbcCruiseRepositoryImpl;
import com.minakov.railwayticketbookingjdbc.service.CruiseService;

import java.util.List;

public class CruiseServiceImpl implements CruiseService {

    private CruiseRepository repository;

    public CruiseServiceImpl() {
        this.repository = new JdbcCruiseRepositoryImpl();
    }

    @Override
    public Cruise findById(String id) {
        return repository.findById(id);
    }

    @Override
    public List<Cruise> findAll() {
        return repository.findAll();
    }
}
