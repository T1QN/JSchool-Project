package com.model.entity.van.dao;

import com.model.dao.impl.AbstractDAO;
import com.model.entity.van.Van;

import java.sql.SQLException;
import java.util.List;

public class VanDAOImpl extends AbstractDAO implements VanDAO {
    @Override
    public void add(Van van) throws SQLException {
        getSessionFactory().openSession().save(van);
    }

    @Override
    public void update(Van van) throws SQLException {
        getSessionFactory().openSession().update(van);
    }

    @Override
    public Van getById(Integer id) throws SQLException {
        return getSessionFactory().openSession().get(Van.class, id);
    }

    @Override
    public List<Van> getAll() throws SQLException {
        return getSessionFactory().openSession().createQuery("FROM Van", Van.class).list();
    }

    @Override
    public void delete(Van van) throws SQLException {
        getSessionFactory().openSession().delete(van);
    }
}
