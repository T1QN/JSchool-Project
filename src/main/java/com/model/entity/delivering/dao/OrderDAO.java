package com.model.entity.delivering.dao;

import com.model.entity.delivering.Order;

import java.sql.SQLException;
import java.util.List;

public interface OrderDAO {

    void add(Order order) throws SQLException;
    void update(Order order) throws SQLException;

    Order getById(Integer id) throws SQLException;

    List<Order> getAll() throws SQLException;
    List<Order> getAllActive() throws SQLException;

    void delete(Order order) throws SQLException;
}
