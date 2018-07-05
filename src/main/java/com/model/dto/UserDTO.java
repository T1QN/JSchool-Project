package com.model.dto;

import java.util.Date;

/**
 * Created by Mandrake on 05.07.2018.
 */
public interface UserDTO {

    ///////////////////////////////////////////////////////////////////////////
    // Getters & Setters
    ///////////////////////////////////////////////////////////////////////////
    String getLogin();
    void setLogin(String login);

    String getPassword();
    void setPassword(String password);

    boolean getAuthorized();
    void setAuthorized(boolean b);

    String getType();
    void setType(String type);


    Date getRegistration();

    @Deprecated
    void setRegistration(Date date);


}
