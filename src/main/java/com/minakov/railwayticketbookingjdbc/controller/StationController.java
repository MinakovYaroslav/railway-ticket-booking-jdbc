package com.minakov.railwayticketbookingjdbc.controller;

import com.minakov.railwayticketbookingjdbc.exception.StationNotFoundException;
import com.minakov.railwayticketbookingjdbc.model.Station;
import com.minakov.railwayticketbookingjdbc.service.StationService;
import com.minakov.railwayticketbookingjdbc.service.impl.StationServiceImpl;

import java.util.List;

public class StationController {

    private StationService stationService;

    public StationController() {
        this.stationService = new StationServiceImpl();
    }

    public Station findById(String id) throws StationNotFoundException {
        Station station = stationService.findById(id);
        if (station == null) {
            throw new StationNotFoundException(id);
        }
        return station;
    }

    public List<Station> findAll() {
        return stationService.findAll();
    }
}
