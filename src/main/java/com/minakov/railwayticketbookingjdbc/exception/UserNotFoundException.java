package com.minakov.railwayticketbookingjdbc.exception;

public class UserNotFoundException extends Throwable {

    private String message;

    public UserNotFoundException(String userId) {
        this.message = "User with id " + userId + " not found";
    }

    @Override
    public String toString() {
        return message;
    }
}
