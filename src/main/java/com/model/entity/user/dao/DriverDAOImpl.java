package com.model.entity.user.dao;

import com.model.dao.impl.AbstractDAO;
import com.model.entity.item.Item;
import com.model.entity.user.Driver;
import com.model.entity.user.User;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("driverDAO")
public class DriverDAOImpl extends AbstractDAO implements DriverDAO {
    @Override
    public void add(Driver driver) {
        getSessionFactory().openSession().save(driver);
    }

    @Override
    public void update(Driver driver) {
        getSessionFactory().openSession().update(driver);
    }

    @Override
    public Driver getById(Integer id) {
        return getSessionFactory().openSession().get(Driver.class, id);
    }

    @Override
    public Driver getByUser(User user) {
        Query<Driver> query = getSessionFactory().openSession().createQuery(
                "FROM Driver D WHERE D.user=:user",
                Driver.class
        );
        query.setParameter("user", user);
        return query.getSingleResult();
    }

    @Override
    public Driver getByNum(String num) {
        Query<Driver> query = getSessionFactory().openSession().createQuery(
                "FROM Driver D WHERE D.num=:num",
                Driver.class
        );
        query.setParameter("num", num);
        return query.getSingleResult();
    }

    @Override
    public List<Driver> getAll() {
        Query<Driver> query = getSessionFactory().openSession().createQuery(
                "FROM Driver",
                Driver.class
        );
        return query.list();
    }

    @Override
    public void delete(Driver driver) {
        getSessionFactory().openSession().delete(driver);
    }
}
