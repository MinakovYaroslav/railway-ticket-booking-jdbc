package com.minakov.railwayticketbookingjdbc.service.impl;

import com.minakov.railwayticketbookingjdbc.config.DatabaseConfiguration;
import com.minakov.railwayticketbookingjdbc.model.DatabaseAccessType;
import com.minakov.railwayticketbookingjdbc.model.Route;
import com.minakov.railwayticketbookingjdbc.repository.RouteRepository;
import com.minakov.railwayticketbookingjdbc.repository.hibernate.HibernateRouteRepositoryImpl;
import com.minakov.railwayticketbookingjdbc.repository.jdbc.JdbcRouteRepositoryImpl;
import com.minakov.railwayticketbookingjdbc.service.RouteService;

import java.util.List;

public class RouteServiceImpl implements RouteService {

    private RouteRepository repository;

    public RouteServiceImpl() {
        this.repository = getRepository();
    }

    @Override
    public Route findById(String id) {
        return repository.findById(id);
    }

    @Override
    public List<Route> findAll() {
        return repository.findAll();
    }

    private RouteRepository getRepository() {
        if (DatabaseConfiguration.PROPERTY.getType().equalsIgnoreCase(DatabaseAccessType.JDBC.get())) {
            return new JdbcRouteRepositoryImpl();
        } else if (DatabaseConfiguration.PROPERTY.getType().equalsIgnoreCase(DatabaseAccessType.HIBERNATE.get())) {
            return new HibernateRouteRepositoryImpl();
        } else {
            throw new RuntimeException("Connection type is invalid!");
        }
    }
}
