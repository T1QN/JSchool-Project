package com.model.entity.item.dao;

import com.model.entity.item.Item;

import com.model.dao.impl.AbstractDAO;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

import java.sql.SQLException;
import java.util.List;

@Repository("itemDAO")
public class ItemDAOImpl extends AbstractDAO implements ItemDAO {
    @Override
    public void add(Item item) throws SQLException {
        getSessionFactory().openSession().save(item);
    }

    @Override
    public void update(Item item)  throws SQLException{
        getSessionFactory().openSession().update(item);
    }

    @Override
    public Item getById(Integer id)  throws SQLException{
        return getSessionFactory().openSession().get(Item.class, id);
    }

    @Override
    public List<Item> getAll()  throws SQLException {
        return getSessionFactory().openSession().createQuery("FROM Item", Item.class).list();
    }

    @Override
    public List<Item> getByStatus(String status)  throws SQLException {
        Query<Item> query = getSessionFactory().openSession().createQuery(
                "FROM Item I WHERE I.status=:status",
                Item.class
        );
        query.setParameter("status", status);
        return query.list();
    }

    @Override
    public List<Item> getPrepared()  throws SQLException{
        return getByStatus("prepared");
    }

    @Override
    public List<Item> getUnload() throws SQLException{
        return getByStatus("unload");
    }

    @Override
    public List<Item> getDelivered() throws SQLException {
        return getByStatus("delivered");
    }

    @Override
    public void delete(Item item) {
        getSessionFactory().openSession().delete(item);
    }
}
