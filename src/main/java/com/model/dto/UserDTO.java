package com.model.dto;

import java.util.Date;

/**
 * Created by Mandrake on 05.07.2018.
 */
public class UserDTO {

    ///////////////////////////////////////////////////////////////////////////
    // Storage Fields
    ///////////////////////////////////////////////////////////////////////////

    private String login;
    private String password;
    private Date registration;
    private RoleDTO role;

    ///////////////////////////////////////////////////////////////////////////
    // Service fields
    ///////////////////////////////////////////////////////////////////////////

    private boolean validate;
    private boolean authorized;

    /**
     * Default constructor without parameters
     */
    public UserDTO() {

    }

    /**
     *
     * @param login
     * @param password
     * @param registration
     * @param role
     */
    public UserDTO(
            final String login,
            final  String password,
            final Date registration,
            final RoleDTO role,
            final boolean validate,
            final boolean authorized) {
        this();
        this.login = login;
        this.password = password;
        this.registration = registration;
        this.role = role;
        this.validate = validate;
        this.authorized = authorized;
    }


    ///////////////////////////////////////////////////////////////////////////
    // Getters & Setters
    ///////////////////////////////////////////////////////////////////////////

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Date getRegistration() {
        return registration;
    }

    public void setRegistration(Date registration) {
        this.registration = registration;
    }

    public RoleDTO getRole() {
        return role;
    }

    public void setRole(RoleDTO role) {
        this.role = role;
    }

    public boolean isValidate() {
        return validate;
    }

    public void setValidate(boolean validate) {
        this.validate = validate;
    }

    public boolean isAuthorized() {
        return authorized;
    }

    public void setAuthorized(boolean authorized) {
        this.authorized = authorized;
    }


}
