package com.model.service.impl;

import com.model.dao.UserDAO;
import com.model.dto.UserDTO;
import com.model.entity.User;
import com.model.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLException;

/**
 * Created by Mandrake on 05.07.2018.
 */
@Service("userService")
public class UserServiceImpl implements UserService{

    /**
     * Instance of user DAO for data operations.
     */
    @Autowired
    private UserDAO userDAO;

    /**
     * Creating a new user in system
     * @param userDTO User Data
     * @return
     */
    @Override
    public UserDTO registerUser(final UserDTO userDTO) {
        try {
            userDAO.add(new User(
                    userDTO.getLogin(),
                    userDTO.getPassword(),
                    userDTO.getRegistration(),
                    userDTO.getType()
            ));
        } catch (SQLException sexp) {
            // Log and other actions to error in registration
            return userDTO;
        }
        userDTO.setAuthorized(true);
        return userDTO;
    }

    /**
     * Authorize current user in system
     * @param userDTO User Data
     * @return modified DTO for current user
     */
    @Override
    public UserDTO loginUser(final UserDTO userDTO) {
        try {
            User user = userDAO.getByLogin(userDTO.getLogin());
            if (user.getPassword().equals(userDTO.getPassword())) {
                userDTO.setAuthorized(true);
            }
        } catch (SQLException sexp) {
            // Log and other actions to error in authorization

        }
        return userDTO;
    }
}
