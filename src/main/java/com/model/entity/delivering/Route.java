package com.model.entity.delivering;

import com.model.entity.delivering.Item;
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
    @Column(name = "city_id")
    private City city;

    @OneToOne(targetEntity = Item.class)
    @Column(name = "item_id")
    private Item item;

    @Column(name = "task")
    private boolean task;

    @ManyToOne(targetEntity = Order.class)
    @Column(name = "order_id")
    private Order order;
}
