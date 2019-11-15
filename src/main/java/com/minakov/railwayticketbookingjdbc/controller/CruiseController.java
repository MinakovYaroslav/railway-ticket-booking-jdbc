package com.minakov.railwayticketbookingjdbc.controller;

import com.minakov.railwayticketbookingjdbc.exception.CruiseNotFoundException;
import com.minakov.railwayticketbookingjdbc.model.Cruise;
import com.minakov.railwayticketbookingjdbc.service.CruiseService;
import com.minakov.railwayticketbookingjdbc.service.impl.CruiseServiceImpl;

import java.util.HashMap;
import java.util.Map;

public class CruiseController {

    private CruiseService cruiseService;

    public CruiseController() {
        this.cruiseService = new CruiseServiceImpl();
    }

    public Cruise findById(String id) throws CruiseNotFoundException {
        Cruise cruise = cruiseService.findById(id);
        if (cruise == null) {
            throw new CruiseNotFoundException(id);
        }
        return cruise;
    }

    public Map<Integer, Cruise> cruiseTable() {
        int number = 1;
        Map<Integer, Cruise> cruises = new HashMap<>();
        for (Cruise cruise : cruiseService.findAll()) {
            cruises.put(number++, cruise);
        }
        return cruises;
    }
}
