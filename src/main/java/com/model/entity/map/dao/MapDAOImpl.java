package com.model.entity.map.dao;

import com.model.dao.impl.AbstractDAO;
import com.model.entity.map.dao.MapDAO;
import com.model.entity.map.City;
import com.model.entity.map.Road;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.sql.SQLException;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Default realization of {@link MapDAO}
 * {@link City} contains list of {@link Road}, which contains callback links on
 * 'from' and 'to' nodes.
 * Cross matrix are not supported on this layer.
 */

public class MapDAOImpl extends AbstractDAO implements MapDAO {

    @Override
    public void addCity(City city)  throws SQLException {
        getSessionFactory().openSession().save(city);
    }

    @Override
    public void connect(Road road)  throws SQLException{
        road.getCity().getNears().add(road);
        Session session = getSessionFactory().openSession();
        session.save(road);
        session.update(road.getCity());
    }

    @Override
    public void connect(City from, City to, Integer range)  throws SQLException{
        connect(new Road(from, to, range));
    }

    @Override
    public void connectBidirectional(City from, City to, Integer range)  throws SQLException{
        connect(from, to, range);
        connect(to, from, range);
    }

    @Override
    public void disconnect(Road road)  throws SQLException{
        City city = road.getCity();
        city.getNears().remove(road);
        getSessionFactory().openSession().update(city);
    }

    @Override
    public void disconnect(City from, City to)  throws SQLException{
        disconnect(get(from, to));
    }

    @Override
    public City getCityById(Integer id)  throws SQLException{
        return getSessionFactory().openSession().get(City.class, id);
    }

    @Override
    public City getCityByName(String name)  throws SQLException{
        Query<City> query = getSessionFactory().openSession().createQuery("FROM City C WHERE C.name-:name", City.class);
        query.setParameter("name", name);
        return query.getSingleResult();
    }

    @Override
    public Road get(City from, City to)  throws SQLException{
        Query<Road> query = getSessionFactory().openSession().createQuery(
                "FROM Road R WHERE R.city=:name AND R.near=:to", Road.class);
        query.setParameter("from", from);
        query.setParameter("to", to);
        return query.getSingleResult();
    }

    @Override
    public Set<Road> getNears(City city)  throws SQLException{
        Query<Road> query = getSessionFactory().openSession().createQuery("FROM Road R WHERE R.city=:city", Road.class);
        query.setParameter("city", city);
        return new HashSet<>(query.list());
    }

    @Override
    public List<City> getAllCities()  throws SQLException{
        Query<City> query =
                getSessionFactory().openSession().createQuery(
                        "FROM City C",
                        City.class
                );
        return query.list();
    }
}
