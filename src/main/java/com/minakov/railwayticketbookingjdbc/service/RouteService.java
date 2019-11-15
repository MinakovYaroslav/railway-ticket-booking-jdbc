package com.minakov.railwayticketbookingjdbc.service;

import com.minakov.railwayticketbookingjdbc.model.Route;

import java.util.List;

public interface RouteService {

    Route findById(String id);

    List<Route> findAll();
}
