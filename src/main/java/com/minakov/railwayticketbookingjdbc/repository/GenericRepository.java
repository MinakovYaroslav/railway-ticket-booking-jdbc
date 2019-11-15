package com.minakov.railwayticketbookingjdbc.repository;

import java.util.List;

public interface GenericRepository<T, ID> {

    List<T> findAll();

    void delete(ID id);

    T findById(ID id);

    T create(T t);

    T update(T t);
}
