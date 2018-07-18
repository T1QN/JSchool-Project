package com.model.entity.delivering;

import com.model.entity.item.Item;
import com.model.entity.map.City;

import javax.persistence.*;

/**
 * Created by Mandrake on 10.07.2018.
 */
@Entity
@Table(name = "route")
public class Route {

    ///////////////////////////////////////////////////////////////////////////
    // Fields block
    ///////////////////////////////////////////////////////////////////////////

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @OneToOne(targetEntity = City.class)
    @JoinColumn(name = "city_id", referencedColumnName = "id")
    private City city;

    @OneToOne(targetEntity = Item.class)
    @JoinColumn(name = "item_id", referencedColumnName = "id")
    private Item item;

    @Column(name = "task")
    private boolean task;

    @ManyToOne(targetEntity = Order.class)
    @JoinColumn(name = "order_id", referencedColumnName = "id")
    private Order order;

    ///////////////////////////////////////////////////////////////////////////
    // Getters & Setters
    ///////////////////////////////////////////////////////////////////////////

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    public boolean isTask() {
        return task;
    }

    public void setTask(boolean task) {
        this.task = task;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    ///////////////////////////////////////////////////////////////////////////
    // Constructors
    ///////////////////////////////////////////////////////////////////////////

    public Route() {

    }

    public Route(City city, Item item, boolean task, Order order) {
        this.city = city;
        this.item = item;
        this.task = task;
        this.order = order;
    }

    public Route(int id, City city, Item item, boolean task, Order order) {
        this.id = id;
        this.city = city;
        this.item = item;
        this.task = task;
        this.order = order;
    }
}
