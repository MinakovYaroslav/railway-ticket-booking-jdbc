package com.minakov.railwayticketbookingjdbc.controller;

import com.minakov.railwayticketbookingjdbc.exception.RouteNotFoundException;
import com.minakov.railwayticketbookingjdbc.model.Route;
import com.minakov.railwayticketbookingjdbc.service.RouteService;
import com.minakov.railwayticketbookingjdbc.service.impl.RouteServiceImpl;

import java.util.List;

public class RouteController {

    private RouteService routeService;

    public RouteController() {
        this.routeService = new RouteServiceImpl();
    }

    public Route findById(String id) throws RouteNotFoundException {
        Route route = routeService.findById(id);
        if (route == null) {
            throw new RouteNotFoundException(id);
        }
        return route;
    }

    public List<Route> findAll() {
        return routeService.findAll();
    }
}
