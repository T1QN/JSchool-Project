package temp;

import com.model.entity.user.Driver;

import javax.persistence.*;
import java.util.List;

/**
 * Created by Mandrake on 10.07.2018.
 */
@Entity
@Table(name = "team")
public class Team {

    ///////////////////////////////////////////////////////////////////////////
    // Fields block
    ///////////////////////////////////////////////////////////////////////////

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    @OneToMany(mappedBy = "team")
    @Column(name = "driver")
    private List<Driver> drivers;

    ///////////////////////////////////////////////////////////////////////////
    // Constructors block
    ///////////////////////////////////////////////////////////////////////////

    public Team() {

    }

    ///////////////////////////////////////////////////////////////////////////
    // Setters & Setters block
    ///////////////////////////////////////////////////////////////////////////

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public List<Driver> getDrivers() {
        return drivers;
    }

    public void setDrivers(List<Driver> drivers) {
        this.drivers = drivers;
    }
}
