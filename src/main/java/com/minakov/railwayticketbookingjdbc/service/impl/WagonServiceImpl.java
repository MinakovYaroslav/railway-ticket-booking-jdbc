package com.minakov.railwayticketbookingjdbc.service.impl;

import com.minakov.railwayticketbookingjdbc.config.DatabaseConfiguration;
import com.minakov.railwayticketbookingjdbc.model.DatabaseAccessType;
import com.minakov.railwayticketbookingjdbc.model.Wagon;
import com.minakov.railwayticketbookingjdbc.repository.WagonRepository;
import com.minakov.railwayticketbookingjdbc.repository.hibernate.HibernateWagonRepositoryImpl;
import com.minakov.railwayticketbookingjdbc.repository.jdbc.JdbcWagonRepositoryImpl;
import com.minakov.railwayticketbookingjdbc.service.WagonService;

import java.util.List;

public class WagonServiceImpl implements WagonService {

    private WagonRepository repository;

    public WagonServiceImpl() {
        this.repository = getRepository();
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

    private WagonRepository getRepository() {
        if (DatabaseConfiguration.PROPERTY.getType().equalsIgnoreCase(DatabaseAccessType.JDBC.get())) {
            return new JdbcWagonRepositoryImpl();
        } else if (DatabaseConfiguration.PROPERTY.getType().equalsIgnoreCase(DatabaseAccessType.HIBERNATE.get())) {
            return new HibernateWagonRepositoryImpl();
        } else {
            throw new RuntimeException("Connection type is invalid!");
        }
    }
}
