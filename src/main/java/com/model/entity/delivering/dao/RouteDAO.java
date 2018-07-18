package com.model.entity.delivering.dao;

import com.model.entity.delivering.Route;

import java.sql.SQLException;
import java.util.List;

public interface RouteDAO {

    void add(Route route) throws SQLException;
    void update(Route route) throws SQLException;

    Route getById(Integer id) throws SQLException;
    List<Route> getAll() throws SQLException;

    void delete(Route route) throws SQLException;
}
