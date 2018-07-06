package com.model.dao.impl;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by Mandrake on 03.07.2018.
 */
public abstract class AbstractDAO {


    /**
     * Link on Sessions Factory bean, which dd all Hibernate's actions.
     */
    private SessionFactory sessionFactory;

    /**
     * Setting session factory instance
     * @param factory seated session factory
     */
    @Autowired
    public void setSessionFactory(final SessionFactory factory) {
        this.sessionFactory = factory;
    }

    /**
     * Getting session factory instance
     * @return geated session factory
     */
    public SessionFactory getSessionFactory() {
        return this.sessionFactory;
    }

    /**
     * Closing active session
     */
    protected void closeSession() {
        sessionFactory.getCurrentSession().close();
    }
}
