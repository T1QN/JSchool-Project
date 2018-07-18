package com.model.entity.user;

import com.model.entity.user.Role;

import javax.persistence.*;
import java.util.Date;

/**
 * Hibernate parsable class for User's entity.
 * Store authentication data for user in system.
 * Created by Mandrake on 25.06.2018.
 */
@Entity
@Table(name = "user")
public class User {

    ///////////////////////////////////////////////////////////////////////////
    // Fields Block
    ///////////////////////////////////////////////////////////////////////////
    /**
     * ID of current user. Auto incrementing my SQL.
     */
    private long id;
    /**
     * Login of current User.
     */
    private String login;
    /**
     * Password of current user. Storing in hash (SHA-256).
     */
    private String password;
    /**
     * Date of creating user.
     */
    @Column (name = "registration")
    private Date registration;
    /**
     * Type of user. Link on UserType's table
     */
    private Role role;

    ///////////////////////////////////////////////////////////////////////////
    // Constructors Block
    ///////////////////////////////////////////////////////////////////////////

    /**
     * Default constructor.
     * Basic initialization of all storing data.
     */
    public User() {

    }

    /**
     * Constructor with all parameters
     * @param loginParam login name for User
     * @param passwordParam hash of password for user
     * @param registrationParam registration date for user
     * @param roleParam role for user
     */
    public User(
            final String loginParam,
            final String passwordParam,
            final Date registrationParam,
            final Role roleParam) {
        this.login = loginParam;
        this.password = passwordParam;
        this.registration = registrationParam;
        this.role = roleParam;
    }
    ///////////////////////////////////////////////////////////////////////////
    // Getters & Setters Block
    ///////////////////////////////////////////////////////////////////////////

    /**
     * Setting ID from current User
     * @return ID from User's instance
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true, nullable = false)
    public long getId() {
        return id;
    }

    /**
     * Setting ID for current User
     * @param idParam seated ID
     */
    public void setId(final long idParam) {
        this.id = idParam;
    }

    /**
     * Getting Login from User's instance
     * @return User's login
     */
    @Column(name = "login")
    public String getLogin() {
        return login;
    }

    /**
     * Setting login for current User
     * @param loginParam User's login
     */
    public void setLogin(final String loginParam) {
        this.login = loginParam;
    }


    /**
     * Geting password from current User
     * @return User's password
     */
    @Column(name = "password")
    public String getPassword() {
        return password;
    }

    /**
     * Setting password for current User
     * @param passwordParam User's login
     */
    public void setPassword(final String passwordParam) {
        this.password = passwordParam;
    }

    /**
     * Geting registration date from current User
     * @return User's registration date
     */
    @Column(name = "registration")
    public Date getRegistration() {
        return registration;
    }

    /**
     * Setting registration for current User
     * @param registrationParam User's login
     */
    public void setRegistration(final Date registrationParam) {
        this.registration = registrationParam;
    }

    /**
     * Getting UserType from current User
     * @return User's role
     */
    @ManyToOne(targetEntity = Role.class, cascade = CascadeType.ALL)
    @JoinColumn(name = "role", referencedColumnName = "id")
    public Role getRole() {
        return role;
    }

    /**
     * Setting UserType for current User
     * @param typeParam seated user role
     */
    public void setRole(final Role typeParam) {
        this.role = typeParam;
    }

    ///////////////////////////////////////////////////////////////////////////
    // Utils block
    ///////////////////////////////////////////////////////////////////////////
    /**
     * Creating instance to string
     * @return created string
     */
    @Override
    public String toString() {
        return new StringBuilder()
                .append(id)
                .append(login)
                .append(password)
                .append(registration.toString())
                .append(role)
                .toString();
    }
}
