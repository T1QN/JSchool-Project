package com.model.entity.map.dao;

import com.model.entity.map.City;
import com.model.entity.map.Road;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * DAO for working with {@link City} and {@link Road} entities.
 * Declare abstract functional for working with this entities as parts of navigation map,
 * presented ad oriented graph, where:
 * <li>{@link City} represented a <b>graph nodes</b>
 * <li>{@link Road} represented a <b>graph edges</b>
 * <p>
 * @author Mandrake 09.07.2018
 */
public interface MapDAO {

    void addCity(City city) throws SQLException;

    void connect(Road road) throws SQLException;
    void connect(City from, City to, Integer range) throws SQLException;
    void connectBidirectional(City from, City to, Integer range) throws SQLException;
    void disconnect(Road road) throws SQLException;
    void disconnect(City from, City to) throws SQLException;

    City getCityById(Integer id) throws SQLException;
    City getCityByName(String name) throws SQLException;

    Road get(City from, City to) throws SQLException;
    Set<Road> getNears(City city) throws SQLException;

    List<City> getAllCities() throws SQLException;
}
