package temp;

import com.model.entity.user.Driver;

import javax.persistence.*;

/**
 * Created by Mandrake on 09.07.2018.
 */
@Entity
@Table(name = "driverlist")
public class DriverList {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    @ManyToOne(targetEntity = Team.class)
    @JoinColumn(name = "team_id")
    private Team team;

    @OneToOne(targetEntity = Driver.class)
    private Driver driver;

    public DriverList() {
    }

    public DriverList(Team team, Driver driver) {

        this.team = team;
        this.driver = driver;
    }

    public long getId() {

        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Team getTeam() {
        return team;
    }

    public void setTeam(Team team) {
        this.team = team;
    }

    public Driver getDriver() {
        return driver;
    }

    public void setDriver(Driver driver) {
        this.driver = driver;
    }
}
