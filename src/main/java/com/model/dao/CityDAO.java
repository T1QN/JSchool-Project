package com.model.dao;

import com.model.entity.map.City;
import com.model.entity.map.Road;

import java.util.List;
import java.util.Map;

/**
 * Created by Mandrake on 09.07.2018.
 */
public interface CityDAO {

    void add(City city);

    void connect(Road road);
    void connect(City from, City to, Integer range);
    void disconnect(Road road);
    void disconnect(City from, City to);

    City getById(Integer id);
    City getByName(String name);

    List<City> getAll();
    Map<City, Integer> getNears(City city);
}
