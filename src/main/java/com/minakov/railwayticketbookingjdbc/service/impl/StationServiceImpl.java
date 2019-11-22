package com.minakov.railwayticketbookingjdbc.service.impl;

import com.minakov.railwayticketbookingjdbc.config.DatabaseConfiguration;
import com.minakov.railwayticketbookingjdbc.model.DatabaseAccessType;
import com.minakov.railwayticketbookingjdbc.model.Station;
import com.minakov.railwayticketbookingjdbc.repository.StationRepository;
import com.minakov.railwayticketbookingjdbc.repository.hibernate.HibernateStationRepositoryImpl;
import com.minakov.railwayticketbookingjdbc.repository.jdbc.JdbcStationRepositoryImpl;
import com.minakov.railwayticketbookingjdbc.service.StationService;

import java.util.List;

public class StationServiceImpl implements StationService {

    private StationRepository repository;

    public StationServiceImpl() {
        this.repository = getRepository();
    }

    @Override
    public Station findById(String id) {
        return repository.findById(id);
    }

    @Override
    public List<Station> findAll() {
        return repository.findAll();
    }

    private StationRepository getRepository() {
        if (DatabaseConfiguration.PROPERTY.getType().equalsIgnoreCase(DatabaseAccessType.JDBC.get())) {
            return new JdbcStationRepositoryImpl();
        } else if (DatabaseConfiguration.PROPERTY.getType().equalsIgnoreCase(DatabaseAccessType.HIBERNATE.get())) {
            return new HibernateStationRepositoryImpl();
        } else {
            throw new RuntimeException("Connection type is invalid!");
        }
    }
}
