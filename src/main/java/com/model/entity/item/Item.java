package com.model.entity.item;

import javax.persistence.*;

/**
 * Created by Mandrake on 06.07.2018.
 */
@Entity
@Table(name = "item")
public class Item {

    private long id;
    private String name;
    private float capacity;
    private String status;

    public Item() {

    }

    public Item(String name, float capacity, String status) {
        this.name = name;
        this.capacity = capacity;
        this.status = status;
    }

    public Item(long id, String name, float capacity, String status) {
        this.id = id;
        this.name = name;
        this.capacity = capacity;
        this.status = status;
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

    @Column(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Column(name = "capacity")
    public float getCapacity() {
        return capacity;
    }

    public void setCapacity(float capacity) {
        this.capacity = capacity;
    }

    @Column(name = "status")
    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
