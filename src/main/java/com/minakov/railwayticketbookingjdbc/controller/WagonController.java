package com.minakov.railwayticketbookingjdbc.controller;

import com.minakov.railwayticketbookingjdbc.exception.WagonNotFoundException;
import com.minakov.railwayticketbookingjdbc.model.Wagon;
import com.minakov.railwayticketbookingjdbc.service.WagonService;
import com.minakov.railwayticketbookingjdbc.service.impl.WagonServiceImpl;

import java.util.List;

public class WagonController {

    private WagonService wagonService;

    public WagonController() {
        this.wagonService = new WagonServiceImpl();
    }

    public Wagon findById(String id) throws WagonNotFoundException {
        Wagon wagon = wagonService.findById(id);
        if (wagon == null) {
            throw new WagonNotFoundException(id);
        }
        return wagon;
    }

    public List<Wagon> findAll() {
        return wagonService.findAll();
    }
}
