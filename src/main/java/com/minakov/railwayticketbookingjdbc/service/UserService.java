package com.minakov.railwayticketbookingjdbc.service;

import com.minakov.railwayticketbookingjdbc.model.User;

import java.util.List;

public interface UserService {

    User findById(String id);

    List<User> findAll();

    User create(User user);
}
