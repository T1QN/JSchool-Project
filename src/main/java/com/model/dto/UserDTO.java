package com.model.dto;

import java.util.Date;
import java.util.Objects;

/**
 * Created by Mandrake on 05.07.2018.
 */
public class UserDTO {

    ///////////////////////////////////////////////////////////////////////////
    // Storage Fields
    ///////////////////////////////////////////////////////////////////////////

    private long id;
    private String login;
    private String password;
    private Date registration;
    private String role;

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
     * @param validate
     * @param authorized
     */
    public UserDTO(
            final Long id,
            final String login,
            final String password,
            final Date registration,
            final String role
    ) {
        this();
        this.id = id;
        this.login = login;
        this.password = password;
        this.registration = registration;
        this.role = role;
    }


    ///////////////////////////////////////////////////////////////////////////
    // Getters & Setters
    ///////////////////////////////////////////////////////////////////////////

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

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

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }


    ///////////////////////////////////////////////////////////////////////////
    // Object extended
    ///////////////////////////////////////////////////////////////////////////


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserDTO userDTO = (UserDTO) o;
        return id == userDTO.id
                && Objects.equals(login, userDTO.login)
                && Objects.equals(password, userDTO.password)
                && Objects.equals(registration, userDTO.registration)
                && Objects.equals(role, userDTO.role);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, login, password, registration, role);
    }
}
