package com.model.entity.delivering.dao;

import com.model.dao.impl.AbstractDAO;
import com.model.entity.delivering.Route;
import org.springframework.stereotype.Repository;

import java.sql.SQLException;
import java.util.List;

@Repository("routeDAO")
public class RouteDAOImpl extends AbstractDAO implements RouteDAO {
    @Override
    public void add(Route route) throws SQLException {
        getSessionFactory().openSession().save(route);
    }

    @Override
    public void update(Route route) throws SQLException {
        getSessionFactory().openSession().update(route);
    }

    @Override
    public Route getById(Integer id) throws SQLException {
        return getSessionFactory().openSession().get(Route.class, id);
    }

    @Override
    public List<Route> getAll() throws SQLException {
        return getSessionFactory().openSession().createQuery("FROM Route", Route.class).list();
    }

    @Override
    public void delete(Route route) throws SQLException {
        getSessionFactory().openSession().delete(route);
    }
}
