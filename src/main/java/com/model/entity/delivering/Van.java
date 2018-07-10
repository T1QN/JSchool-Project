package com.model.entity.delivering;

import com.model.entity.map.City;

import javax.persistence.*;

/**
 * Created by Mandrake on 09.07.2018.
 */
@Entity
@Table(name = "van")
public class Van {
    ///////////////////////////////////////////////////////////////////////////
    // Fields block
    ///////////////////////////////////////////////////////////////////////////

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    @Column(name = "reg_num")
    private String num;

    @Column(name = "team_size")
    private int teamSize;

    @Column(name = "capacity")
    private float capacity;

    @Column(name = "status")
    private boolean status;

    @ManyToOne(targetEntity = City.class)
    @Column(name = "current_city")
    private City currentCity;

    ///////////////////////////////////////////////////////////////////////////
    // Constructors block
    ///////////////////////////////////////////////////////////////////////////

    public Van() {

    }

    public Van(String num, int teamSize, float capacity, boolean status, City currentCity) {
        this.num = num;
        this.teamSize = teamSize;
        this.capacity = capacity;
        this.status = status;
        this.currentCity = currentCity;
    }

    ///////////////////////////////////////////////////////////////////////////
    // Getters & Setters block
    ///////////////////////////////////////////////////////////////////////////

    public long getId() {
        return this.id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNum() {
        return num;
    }

    public void setNum(String num) {
        this.num = num;
    }

    public int getTeamSize() {
        return teamSize;
    }

    public void setTeamSize(int teamSize) {
        this.teamSize = teamSize;
    }

    public float getCapacity() {
        return capacity;
    }

    public void setCapacity(float capacity) {
        this.capacity = capacity;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public City getCurrentCity() {
        return currentCity;
    }

    public void setCurrentCity(City currentCity) {
        this.currentCity = currentCity;
    }
}
