package com.model.entity.user.dao;

import com.model.dao.impl.AbstractDAO;
import com.model.entity.user.Role;
import com.model.entity.user.User;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by Mandrake on 05.07.2018.
 */
@Repository("userDAO")
@Scope("singleton")
public class UserDAOImpl extends AbstractDAO implements UserDAO {
    /**
     * Add new user in DB
     * @param user added user
     * @throws SQLException
     */
    @Override
    @Transactional(propagation = Propagation.MANDATORY)
    public void add(final User user) throws SQLException {
        getSessionFactory().openSession().save(user);
    }

    /**
     * Getting list of all users from DB
     * @return list of users
     * @throws SQLException
     */
    @Override
    @Transactional(propagation = Propagation.MANDATORY, readOnly = true)
    public List<User> getAll() throws SQLException {
        return getSessionFactory().openSession().createQuery("FROM User", User.class).list();
    }

    /**
     * Getting list of all users from DB by their type
     * @param role gated user type
     * @return list of users
     * @throws SQLException
     */
    @Override
    @Transactional(propagation = Propagation.MANDATORY, readOnly = true)
    public List<User> getAllByRole(final Role role) throws SQLException {
        Session s = getSessionFactory().openSession();
        Query<User> query = s.createQuery("FROM User WHERE Role=:role", User.class);
        query.setParameter("role", role);
        return query.list();
    }

    /**
     * Getting User instance from DB by ID
     * @param id user's id
     * @return
     * @throws SQLException
     */
    @Override
    @Transactional(propagation = Propagation.MANDATORY, readOnly = true)
    public User getById(final Integer id) throws SQLException {
        return getSessionFactory().openSession().get(User.class, id);
    }

    /**
     * Getting user by login name from database
     * @param login user's login
     * @return founded User's instance
     * @throws SQLException throws if something wrong
     */
    @Override
    public User getByLogin(final String login) throws SQLException {
        Query<User> query = getSessionFactory().openSession().createQuery("FROM User U WHERE U.login=:login", User.class);
        query.setParameter("login", login);
        return query.getSingleResult();
    }

    /**
     * Updating user data into DB
     * @param user current user
     * @throws SQLException
     */
    @Override
    @Transactional(propagation = Propagation.MANDATORY)
    public void update(final User user) throws SQLException {
        getSessionFactory().openSession().update(user);
    }

    /**
     *  Deleting user from DB
     * @param user current user
     * @throws SQLException
     */
    @Override
    @Transactional(propagation = Propagation.MANDATORY)
    public void delete(final User user) throws SQLException {
        getSessionFactory().openSession().delete(user);
    }
}
