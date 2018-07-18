package com.model.entity.map;

import javax.persistence.*;

/**
 * Created by Mandrake on 09.07.2018.
 */
@Entity
@Table(name = "road")
public class Road {

    ///////////////////////////////////////////////////////////////////////////
    // Fields
    ///////////////////////////////////////////////////////////////////////////
    private long id;
    private City city;
    private City near;
    private Integer range;

    public Road() {

    }
    public Road(City city, City near, Integer range) {
        this.city = city;
        this.near = near;
        this.range = range;
    }
    public Road(long id, City city, City near, Integer range) {
        this.id = id;
        this.city = city;
        this.near = near;
        this.range = range;
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

    @ManyToOne(targetEntity = City.class)
    @JoinColumn(name = "city_id", referencedColumnName = "id")
    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }

    @ManyToOne(targetEntity = City.class)
    @JoinColumn(name = "near_city_id", referencedColumnName = "id")
    public City getNear() {
        return near;
    }

    public void setNear(City near) {
        this.near = near;
    }

    public Integer getRange() {
        return range;
    }

    public void setRange(Integer range) {
        this.range = range;
    }
}
