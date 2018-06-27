package com.model.hibernate.user;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import javax.persistence.Id;
import java.util.Date;

/**
 * Hibernate parsable class for User's entity.
 * Store authentication data for user in system.
 * Created by Mandrake on 25.06.2018.
 */
@Entity
@Table(name = "User")
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
    private UserType type;

    /**
     * Getting ID from User instance.
     * @return User's ID
     */
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
     * @param idParam ID for User
     * @param loginParam login name for User
     * @param passwordParam hash of password for user
     * @param registrationParam registration date for user
     * @param typeParam type for user
     */
    public User(final long idParam, final String loginParam, final String passwordParam, final Date registrationParam, final UserType typeParam) {
        this.id = idParam;
    }
    ///////////////////////////////////////////////////////////////////////////
    // Getters & Setters Block
    ///////////////////////////////////////////////////////////////////////////

    /**
     * Setting ID from current User
     * @return ID from User's instance
     */
    @Id
    @PrimaryKeyJoinColumn
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

    public UserType getType() {
        return type;
    }

    public void setType(UserType type) {
        this.type = type;
    }
}
