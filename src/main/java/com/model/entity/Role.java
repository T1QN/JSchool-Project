package com.model.entity;

import javax.persistence.*;

/**
 * Created by Mandrake on 06.07.2018.
 */
@Entity
@Table(name = "role")
public class Role {

    private long id;
    private String role;

    public Role() {

    }
    public Role(String role) {
        this.id = id;
        this.role = role;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Column(name = "role", unique = true)
    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}
