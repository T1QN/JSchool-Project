package com.model.service.impl;

import com.model.dao.RoleDAO;
import com.model.dao.UserDAO;
import com.model.dto.UserDTO;
import com.model.entity.User;
import com.model.service.UserService;
import com.model.service.ValidationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLException;

/**
 * Created by Mandrake on 05.07.2018.
 */
@Service("userService")
public class UserServiceImpl implements UserService {

    ///////////////////////////////////////////////////////////////////////////
    // DAO objects
    ///////////////////////////////////////////////////////////////////////////
    /**
     * Instance of user DAO for data operations.
     */
    private UserDAO userDAO;
    /**
     *
     */
    private RoleDAO roleDAO;
    /**
     * Validation service which check user dto data on correct values
     */
    private ValidationService validationService;


    /**
     *
     * @param userDAO
     */
    @Autowired
    public void setUserDAO(final UserDAO userDAO) {
        this.userDAO = userDAO;
    }
    /**
     *
     * @param roleDAO
     */
    @Autowired
    public void setRoleDAO(final RoleDAO roleDAO) {
        this.roleDAO = roleDAO;
    }
    /**
     * Setting validation service
     * @param validationService
     */
    @Autowired
    public void setValidationService(final ValidationService validationService) {
        this.validationService = validationService;
    }
    /**
     * Creating new user in system
     * @return modified DTO for current user
     */
    @Override
    public UserDTO registerUser(final UserDTO userDTO) {
        validationService.validate(userDTO);
        if (!userDTO.isValidate())
            return userDTO;
        try {
            userDAO.add(new User(
                    userDTO.getLogin(),
                    userDTO.getPassword(),
                    userDTO.getRegistration(),
                    roleDAO.getByRole(
                            userDTO
                                    .getRole()
                                    .getRole()
                            )
                    )
            );
        } catch (SQLException sexp) {
            // Log and other actions to error in registration
            sexp.printStackTrace();
            return userDTO;
        }
        return loginUser(userDTO);
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
                // Authorization moment
                userDTO.setAuthorized(true);
            }
        } catch (SQLException sexp) {
            sexp.printStackTrace();
            // Log and other actions to error in registration
            return userDTO;
        } return userDTO;
    }
}
