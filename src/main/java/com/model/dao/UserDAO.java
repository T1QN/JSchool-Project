package com.model.dao;

import com.model.dto.UserDTO;
import com.model.entity.User;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by Mandrake on 25.06.2018.
 */
public interface UserDAO {
    /**
     * Adding a new user in database
     * @param user added user
     * @throws SQLException throws if something wrong
     */
    void add(User user) throws SQLException;

    /**
     * Getting list of all users
     * @return list of all users
     * @throws SQLException throws if something wrong
     */
    List<User> getAll() throws SQLException;

    /**
     * Getting all Users from database, who are current user type
     * @param type gated user type
     * @return list of users
     * @throws SQLException throws if something wrong
     */
    List<User> getAllbyType(String type) throws SQLException;

    /**
     * Getting user by id from database
     * @param id user's id
     * @return founded User's instance
     * @throws SQLException throws if something wrong
     */
    User getById(Integer id) throws SQLException;

    /**
     * Getting user by login name from database
     * @param login user's login
     * @return founded User's instance
     * @throws SQLException throws if something wrong
     */
    User getByLogin(String login) throws SQLException;
    /**
     * Updating state for current user
     * @param user current user
     * @throws SQLException throws if something wrong
     */
    void update(User user) throws SQLException;

    /**
     * Deleting current user from database
     * @param user current user
     * @throws SQLException throws if something wrong
     */
    void delete(User user) throws SQLException;

    /**
     * Tranfer current DAO to DTO
     * @return
     */
    // UserDTO toDTO();

    /*
    /**
     * Generation UserDAO object from received UserDTO object
     * @param userDTO received DTO object
     * @return generated DAO object
     *
    static UserDAO fromDTO(UserDTO userDTO) {
        return null;
    }
    */
}
