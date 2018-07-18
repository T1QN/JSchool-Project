package com.model.service.impl;

import com.model.dto.UserDTO;
import com.model.entity.user.User;
import com.model.entity.user.dao.UserDAO;
import com.model.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLException;

/**
 * .
 */
@Service("userService")
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDAO userDAO;

    @Autowired
    private ModelMapper userModelMapper;

    @Override
    public boolean registerUser(UserDTO userDTO) {
        try {
            userDAO.add(userModelMapper.map(userDTO, User.class));
        } catch (SQLException sexp) {
            return false;
        } return true;
    }

    @Override
    public UserDTO updateUserData(UserDTO user) {
        try {
            userDAO.update(userModelMapper.map(user, User.class));
        } catch (SQLException sexp) {
            return null;
        } return user;
    }

    public UserDAO getUserDAO() {
        return userDAO;
    }

    public void setUserDAO(UserDAO userDAO) {
        this.userDAO = userDAO;
    }

    public void setUserModelMapper(ModelMapper userModelMapper) {
        this.userModelMapper = userModelMapper;
    }
}
