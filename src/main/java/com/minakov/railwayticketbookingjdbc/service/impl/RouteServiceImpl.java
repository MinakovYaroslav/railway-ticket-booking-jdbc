package com.minakov.railwayticketbookingjdbc.service.impl;

import com.minakov.railwayticketbookingjdbc.model.Route;
import com.minakov.railwayticketbookingjdbc.repository.RouteRepository;
import com.minakov.railwayticketbookingjdbc.repository.jdbc.JdbcRouteRepositoryImpl;
import com.minakov.railwayticketbookingjdbc.service.RouteService;

import java.util.List;

public class RouteServiceImpl implements RouteService {

    private RouteRepository repository;

    public RouteServiceImpl() {
        this.repository = new JdbcRouteRepositoryImpl();
    }

    @Override
    public Route findById(String id) {
        return repository.findById(id);
    }

    @Override
    public List<Route> findAll() {
        return repository.findAll();
    }
}
