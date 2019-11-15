package com.minakov.railwayticketbookingjdbc.service.impl;

import com.minakov.railwayticketbookingjdbc.model.User;
import com.minakov.railwayticketbookingjdbc.repository.UserRepository;
import com.minakov.railwayticketbookingjdbc.repository.jdbc.JdbcUserRepositoryImpl;
import com.minakov.railwayticketbookingjdbc.service.UserService;

import java.util.List;

public class UserServiceImpl implements UserService {

    private UserRepository userRepository;

    public UserServiceImpl() {
        userRepository = new JdbcUserRepositoryImpl();
    }

    @Override
    public User findById(String id) {
        return userRepository.findById(id);
    }

    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }

    @Override
    public User create(User user) {
        return userRepository.create(user);
    }
}
