package com.minakov.railwayticketbookingjdbc.service.impl;

import com.minakov.railwayticketbookingjdbc.config.DatabaseConfiguration;
import com.minakov.railwayticketbookingjdbc.model.Cruise;
import com.minakov.railwayticketbookingjdbc.model.DatabaseAccessType;
import com.minakov.railwayticketbookingjdbc.repository.CruiseRepository;
import com.minakov.railwayticketbookingjdbc.repository.hibernate.HibernateCruiseRepositoryImpl;
import com.minakov.railwayticketbookingjdbc.repository.jdbc.JdbcCruiseRepositoryImpl;
import com.minakov.railwayticketbookingjdbc.service.CruiseService;

import java.util.List;

public class CruiseServiceImpl implements CruiseService {

    private CruiseRepository repository;

    public CruiseServiceImpl() {
        this.repository = getRepository();
    }

    @Override
    public Cruise findById(String id) {
        return repository.findById(id);
    }

    @Override
    public List<Cruise> findAll() {
        return repository.findAll();
    }

    private CruiseRepository getRepository() {
        if (DatabaseConfiguration.PROPERTY.getType().equalsIgnoreCase(DatabaseAccessType.JDBC.get())) {
            return new JdbcCruiseRepositoryImpl();
        } else if (DatabaseConfiguration.PROPERTY.getType().equalsIgnoreCase(DatabaseAccessType.HIBERNATE.get())) {
            return new HibernateCruiseRepositoryImpl();
        } else {
            throw new RuntimeException("Connection type is invalid!");
        }
    }
}
