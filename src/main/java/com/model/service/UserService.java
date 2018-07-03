package com.model.service;

import com.model.dao.UserDAO;
import com.model.entity.User;
import com.model.entity.UserType;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.transaction.annotation.Transactional;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by Mandrake on 03.07.2018.
 */
public class UserService extends AbstractService implements UserDAO{

    /**
     *
     * @param user added user
     * @throws SQLException
     */
    @Transactional
    @Override
    public void add(final User user) throws SQLException {
        getSessionFactory().openSession().save(user);
        closeSession();
    }

    /**
     *
     * @return
     * @throws SQLException
     */
    @Transactional
    @Override
    public List<User> getAll() throws SQLException {
        Query selectQuery = getSessionFactory().openSession().createNativeQuery("SELECT * FROM USER");
        closeSession();
        return selectQuery.list();
    }

    /**
     *
     * @param type gated user type
     * @return
     * @throws SQLException
     */
    @Override
    public List<User> getAllbyType(final UserType type) throws SQLException {
        return null;
    }

    @Override
    public User getById(int id) throws SQLException {
        return null;
    }

    @Override
    public void update(User user) throws SQLException {

    }

    @Override
    public void delete(User user) throws SQLException {

    }


}
