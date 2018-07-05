package com.model.dto;

import com.model.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Date;

/**
 * Created by Mandrake on 05.07.2018.
 */

@Repository
public class UserDTOImpl implements UserDTO {


    @Autowired
    private User user;

    private boolean authorized;

    @Override
    public String getLogin() {
        return user.getLogin();
    }

    @Override
    public void setLogin(final String login) {

    }

    @Override
    public String getPassword() {
        return null;
    }

    @Override
    public void setPassword(String password) {

    }

    @Override
    public boolean getAuthorized() {
        return false;
    }

    @Override
    public void setAuthorized(boolean b) {

    }

    @Override
    public String getType() {
        return null;
    }

    @Override
    public void setType(String type) {

    }

    @Override
    public Date getRegistration() {
        return null;
    }

    @Override
    public void setRegistration(Date date) {

    }
}
