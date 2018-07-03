package com.model.dao;

import com.model.entity.UserType;

import java.sql.SQLException;

/**
 * Created by Mandrake on 03.07.2018.
 */
public interface UserTypeDAO {
    /**
     * Getting a UserType instance by ID
     * @param id getting ID
     * @return gated UserType
     * @throws SQLException throws if something wrong
     */
    UserType getById(int id) throws SQLException;

    /**
     * Add a new UserType in database
     * @param type added UserType
     * @throws SQLException throws if something wrong
     */
    void add(UserType type) throws SQLException;
}
