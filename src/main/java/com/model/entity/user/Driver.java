package com.model.entity.user;

import com.model.entity.delivering.Order;
import com.model.entity.delivering.Van;
import com.model.entity.map.City;

import javax.persistence.*;

/**
 * Created by Mandrake on 06.07.2018.
 */
@Entity
@Table(name = "driver")
public class Driver {
    ///////////////////////////////////////////////////////////////////////////
    // Fields block
    ///////////////////////////////////////////////////////////////////////////
    /**
     * Driver's ID.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    /**
     * Driver's Name.
     */
    @Column(name = "name")
    private String name;

    /**
     * Driver's surname.
     */
    @Column(name = "surname")
    private String surname;

    /**
     * Driver's unique number.
     */
    @Column(name = "num")
    private long num;

    /**
     * Count of hours worked by driver in current month.
     */
    @Column(name = "hours")
    private int hours;

    /**
     * Current city location for this driver.
     */
    @ManyToOne(targetEntity = City.class, cascade = CascadeType.ALL)
    @Column(name = "city")
    private City city;

    /**
     * Current van with this driver.
     */
    @ManyToOne(targetEntity = Van.class)
    @JoinColumn(name = "van_id")
    private int van;

    /**
     * Link on user's instance for associated with this driver.
     */
    @OneToOne(targetEntity = User.class)
    @JoinColumn(name = "user_id")
    private User user;

    /**
     * Order, processed by current driver.
     */
    @ManyToOne(targetEntity = Order.class)
    @JoinColumn(name = "order_id")
    private Order order;



    ///////////////////////////////////////////////////////////////////////////
    // Constructors block
    ///////////////////////////////////////////////////////////////////////////

    /**
     * Default constructor without parameters.
     */
    public Driver() {

    }

    /**
     * Full constructors with all parameters (except ID).
     * @param nameParam name of driver
     * @param surnameParam surname of driver
     * @param numParam unique number of driver
     * @param hoursParam worked hours in this month
     * @param cityParam current city location
     * @param vanParam current van
     * @param userParam associated user
     */
    public Driver(final String nameParam,
                  final String surnameParam,
                  final long numParam,
                  final int hoursParam,
                  final City cityParam,
                  final int vanParam,
                  final User userParam) {
        this.name = nameParam;
        this.surname = surnameParam;
        this.num = numParam;
        this.hours = hoursParam;
        this.city = cityParam;
        this.van = vanParam;
        this.user = userParam;
    }

    /**
     * Getting ID.
     * @return id
     */
    public long getId() {
        return id;
    }

    /**
     * Setting ID.
     * @param idParam id
     */
    public void setId(final long idParam) {
        this.id = idParam;
    }

    /**
     * Getting name.
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     * Setting name.
     * @param nameParam name
     */
    public void setName(final String nameParam) {
        this.name = nameParam;
    }

    /**
     * Getting surname.
     * @return surname
     */
    public String getSurname() {
        return surname;
    }

    /**
     * Setting surname.
     * @param surnameParam surname
     */
    public void setSurname(final String surnameParam) {
        this.surname = surnameParam;
    }

    /**
     * Getting unique num.
     * @return unique num
     */
    public long getNum() {
        return num;
    }

    /**
     * Setting unique num.
     * @param numParam unique num
     */
    public void setNum(final long numParam) {
        this.num = numParam;
    }

    /**
     * Getting worked hours.
     * @return worked hours
     */
    public int getHours() {
        return hours;
    }

    /**
     * setting worked hours.
     * @param hoursParam worked hours
     */
    public void setHours(final int hoursParam) {
        this.hours = hoursParam;
    }

    /**
     * Getting current location.
     * @return current city location
     */
    public City getCity() {
        return city;
    }

    /**
     * Setting current city location.
     * @param cityParam current city location
     */
    public void setCity(final City cityParam) {
        this.city = cityParam;
    }

    /**
     * Getting current van.
     * @return current van
     */
    public int getVan() {
        return van;
    }

    /**
     * Setting current van.
     * @param vanParam current van
     */
    public void setVan(final int vanParam) {
        this.van = vanParam;
    }

    /**
     * Getting user association.
     * @return user association
     */
    public User getUser() {
        return user;
    }

    /**
     * Setting user association.
     * @param userParam user association
     */
    public void setUser(final User userParam) {
        this.user = userParam;
    }

    /**
     * Getting order for current driver.
     * @return order
     */
    public Order getOrder() {
        return order;
    }

    /**
     * Setting order for current driver.
     * @param orderParam orderParam
     */
    public void setOrder(final Order orderParam) {
        this.order = orderParam;
    }
}
