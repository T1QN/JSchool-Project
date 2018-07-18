package com.model.entity.delivering.dao;

import com.model.dao.impl.AbstractDAO;
import com.model.entity.delivering.Order;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

import java.sql.SQLException;
import java.util.List;

@Repository("orderDAO")
public class OrderDAOImpl extends AbstractDAO implements OrderDAO {
    @Override
    public void add(Order order)  throws SQLException {
        getSessionFactory().openSession().save(order);
    }

    @Override
    public void update(Order order)  throws SQLException {
        getSessionFactory().openSession().update(order);
    }

    @Override
    public Order getById(Integer id) throws SQLException {
        return getSessionFactory().openSession().get(Order.class, id);
    }

    @Override
    public List<Order> getAll() throws SQLException {
        return getSessionFactory().openSession().createQuery("FROM Order", Order.class).list();
    }

    @Override
    public List<Order> getAllActive() throws SQLException {
        Query<Order> query = getSessionFactory().openSession().createQuery(
                "FROM Order O WHERE O.status=:status",
                Order.class
        );
        query.setParameter("status", true);
        return query.list();
    }

    @Override
    public void delete(Order order) throws SQLException {
        getSessionFactory().openSession().delete(order);
    }
}
