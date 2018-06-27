package com.model.hibernate.user;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

/**
 * Created by Mandrake on 25.06.2018.
 */
@Entity
@Table (name = "UserType")
public class UserType {

    /**
     * ID current UserType
     */
    private long id;
    /**
     * Name of current UserType
     */
    private String type;

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
