package com.model.entity.user.dao;

import com.model.entity.user.Driver;
import com.model.entity.user.User;

import java.util.List;

public interface DriverDAO {
    void add(Driver driver);
    void update(Driver driver);

    Driver getById(Integer id);
    Driver getByUser(User user);
    Driver getByNum(String num);

    List<Driver> getAll();

    void delete(Driver driver);
}
