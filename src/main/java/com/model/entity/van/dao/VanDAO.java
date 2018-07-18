package com.model.entity.van.dao;

import com.model.entity.van.Van;

import java.sql.SQLException;
import java.util.List;

public interface VanDAO  {
    void add(Van van) throws SQLException;
    void update(Van van) throws SQLException;

    Van getById(Integer id) throws SQLException;
    List<Van> getAll() throws SQLException;

    void delete(Van van) throws SQLException;
}
