package com.model.dao;

import com.model.entity.Role;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by Mandrake on 06.07.2018.
 */
public interface RoleDAO {

    List<Role> getAll() throws SQLException;
    Role getById(Integer id) throws SQLException;
    Role getByRole(String role) throws SQLException;
}
