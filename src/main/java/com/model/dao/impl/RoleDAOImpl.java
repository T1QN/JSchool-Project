package com.model.dao.impl;

import com.model.dao.RoleDAO;
import com.model.entity.user.Role;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Mandrake on 06.07.2018.
 */

@Repository("roleDAO")
@Scope("singleton")
public class RoleDAOImpl extends AbstractDAO implements RoleDAO {

    /**
     * Get all roles from DB
     * @return list of all roles
     */
    @Override
    public List<Role> getAll() {
        Session s = getSessionFactory().openSession();
        List<Role> result = s.createQuery("FROM Role", Role.class).list();
        s.close();
        return result;
    }

    /**
     * Get role by ID
     * @param id role ID
     * @return role with current id
     */
    @Override
    public Role getById(final Integer id) {
        Session s = getSessionFactory().openSession();
        Role result = s.get(Role.class, id);
        s.close();
        return result;
    }

    /**
     * Get named role
     * @param role name of role
     * @return named role
     */
    @Override
    public Role getByRole(final String role) {
        Session s = getSessionFactory().openSession();
        Query<Role> query = s.createQuery("FROM Role R WHERE R.role=:role", Role.class);
        query.setParameter("role", role);
        Role result = query.getSingleResult();
        s.close();
        return result;
    }
}
