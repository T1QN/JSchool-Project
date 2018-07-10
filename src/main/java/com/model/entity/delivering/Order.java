package com.model.entity.delivering;

import com.model.entity.user.Driver;

import javax.persistence.*;
import java.util.Set;

/**
 * Created by Mandrake on 10.07.2018.
 */
@Entity
@Table(name = "logisticorder")
public class Order {

    ///////////////////////////////////////////////////////////////////////////
    // Fields block
    ///////////////////////////////////////////////////////////////////////////

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    @Column(name = "status")
    private boolean status;

    @OneToOne(targetEntity = Van.class)
    @Column(name = "van_id")
    private Van van;

    @OneToMany(targetEntity = Driver.class, mappedBy = "loigsticorder")
    private Set<Driver> team;

    @OneToMany(targetEntity = Route.class, mappedBy = "logisticorder")
    private Set<Route> route;

    ///////////////////////////////////////////////////////////////////////////
    // Getters & Setters block
    ///////////////////////////////////////////////////////////////////////////

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public Van getVan() {
        return van;
    }

    public void setVan(Van van) {
        this.van = van;
    }

    public Set<Driver> getTeam() {
        return team;
    }

    public void setTeam(Set<Driver> team) {
        this.team = team;
    }

    public Set<Route> getRoute() {
        return route;
    }

    public void setRoute(Set<Route> route) {
        this.route = route;
    }

    ///////////////////////////////////////////////////////////////////////////
    // Constructors block
    ///////////////////////////////////////////////////////////////////////////

    public Order() {

    }

    public Order(boolean status, Van van, Set<Driver> team, Set<Route> route) {

        this.status = status;
        this.van = van;
        this.team = team;
        this.route = route;
    }

}
