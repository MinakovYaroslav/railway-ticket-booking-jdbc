package com.minakov.railwayticketbookingjdbc.service.impl;

import com.minakov.railwayticketbookingjdbc.model.Wagon;
import com.minakov.railwayticketbookingjdbc.repository.WagonRepository;
import com.minakov.railwayticketbookingjdbc.repository.jdbc.JdbcWagonRepositoryImpl;
import com.minakov.railwayticketbookingjdbc.service.WagonService;

import java.util.List;

public class WagonServiceImpl implements WagonService {

    private WagonRepository repository;

    public WagonServiceImpl() {
        this.repository = new JdbcWagonRepositoryImpl();
    }

    @Override
    public Wagon findById(String id) {
        return repository.findById(id);
    }

    @Override
    public List<Wagon> findAll() {
        return repository.findAll();
    }

    @Override
    public Wagon update(Wagon wagon) {
        return repository.update(wagon);
    }
}
