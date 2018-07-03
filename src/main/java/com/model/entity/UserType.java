package com.model.entity;

import javax.persistence.*;

/**
 * Created by Mandrake on 25.06.2018.
 */
@Entity
@Table (name = "UserType")
public class UserType {

    /**
     * ID current UserType
     */
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    /**
     * Name of current UserType
     */
    private String type;

    /**
     * Default Constructor
     */
    public UserType() {

    }

    /**
     * Full Field Constructor
     * @param typeParam Gated type
     */
    public UserType(final String typeParam) {
        this.type = typeParam;
    }

    /**
     * Getting ID from current UserType
     * @return
     */
    @Id
    @PrimaryKeyJoinColumn
    @Column(name = "id", unique = true, nullable = false)
    public long getId() {
        return id;
    }
    /**
     * Setting ID for current UserType
     * @param idParam seated param
     */
    public UserType(final long idParam) {
        this.id = idParam;
    }

    /**
     * Getting type name from current UserType
     * @return type name
     */
    @Column(name = "type", unique = true, nullable = false)
    public String getType() {
        return type;
    }
    /**
     * Setting type name for current UserType
     * @param typeName seated param
     */
    public void setType(final String typeName) {
        this.type = type;
    }
}
