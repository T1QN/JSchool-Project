package com.model.entity.map;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.GeneratedValue;
import javax.persistence.Column;

import javax.persistence.GenerationType;

import java.util.Set;

/**
 * Class entity for City table.
 */
@Entity
@Table(name = "city")
public class City {

    /**
     * Private ID for current city.
     */
    private long id;
    /**
     * Name of current city.
     */
    private String name;

    /**
     * List of nearest cities.
     */
    private Set<Road> nears;

    /**
     * Default constructor without parameters.
     */
    public City() {

    }

    /**
     * Constructor with all parameters except ID.
     * @param nameParam  Name of city
     * @param nearsParam List of Nearest City
     */
    public City(final String nameParam, final Set<Road> nearsParam) {
        this.name = nameParam;
        this.nears = nearsParam;
    }

    /**
     * Getting ID function.
     * @return id from current city
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    public long getId() {
        return id;
    }
    /**
     * Setting ID for current City.
     * @param idParam seated ID
     */
    public void setId(final long idParam) {
        this.id = idParam;
    }

    /**
     * Getting name of city.
     * @return name of city
     */
    @Column(name = "name")
    public String getName() {
        return name;
    }

    /**
     * Setting name of city.
     * @param nameParam name of city
     */
    public void setName(final String nameParam) {
        this.name = nameParam;
    }

    /**
     * Getting list of all nears cities.
     * @return list of all nears cities
     */
    @ManyToMany(targetEntity = Road.class)
    public Set<Road> getNears() {
        return this.nears;
    }

    /**
     * Setting list of all nears cities.
     * @param nearsParam list of all nears cities
     */
    public void setNears(final Set<Road> nearsParam) {
        this.nears = nearsParam;
    }
}
