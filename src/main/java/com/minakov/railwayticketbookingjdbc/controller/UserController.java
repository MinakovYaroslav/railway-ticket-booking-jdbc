package com.minakov.railwayticketbookingjdbc.controller;

import com.minakov.railwayticketbookingjdbc.exception.UserNotFoundException;
import com.minakov.railwayticketbookingjdbc.model.User;
import com.minakov.railwayticketbookingjdbc.service.UserService;
import com.minakov.railwayticketbookingjdbc.service.impl.UserServiceImpl;

import java.sql.Date;
import java.util.List;

public class UserController {

    private UserService userService;

    public UserController() {
        userService = new UserServiceImpl();
    }

    public User findById(String id) throws UserNotFoundException {
        User user = userService.findById(id);
        if (user == null) {
            throw new UserNotFoundException(id);
        }
        return user;
    }

    public User create(User user) {
        return userService.create(user);
    }

    public List<User> findAll() {
        return userService.findAll();
    }

    public User create(String firstName, String lastName, Date birthday) {
        User user = new User();
        user.setFirstName(firstName);
        user.setLastName(lastName);
        user.setBirthday(birthday);
        return userService.create(user);
    }
}
