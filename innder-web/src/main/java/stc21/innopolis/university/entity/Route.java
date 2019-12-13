package stc21.innopolis.university.entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "route")
public class Route {

    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(generator = "USER_ID_GENERATOR", strategy = GenerationType.AUTO)
    @SequenceGenerator(name = "USER_ID_GENERATOR", allocationSize = 1, sequenceName = "users_id_seq")
    private Long id;

    @Column(name = "startcity", nullable = false)
    private String startcity;

    @Column(name = "endcity", nullable = false)
    private String endcity;

    @Column(name = "startstreet", nullable = false)
    private String startstreet;

    @Column(name = "endstreet", nullable = false)
    private String endstreet;

    @Column(name = "streetnumberstart", nullable = false)
    private String streetnumberstart;

    @Column(name = "streetnumberend", nullable = false)
    private String streetnumberend;

    public Route() {
    }

    public Route(String startcity, String endcity, String startstreet, String endstreet, String streetnumberstart, String streetnumberend) {
        this.startcity = startcity;
        this.endcity = endcity;
        this.startstreet = startstreet;
        this.endstreet = endstreet;
        this.streetnumberstart = streetnumberstart;
        this.streetnumberend = streetnumberend;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getStartcity() {
        return startcity;
    }

    public void setStartcity(String startcity) {
        this.startcity = startcity;
    }

    public String getEndcity() {
        return endcity;
    }

    public void setEndcity(String endcity) {
        this.endcity = endcity;
    }

    public String getStartstreet() {
        return startstreet;
    }

    public void setStartstreet(String startstreet) {
        this.startstreet = startstreet;
    }

    public String getEndstreet() {
        return endstreet;
    }

    public void setEndstreet(String endstreet) {
        this.endstreet = endstreet;
    }

    public String getStreetnumberstart() {
        return streetnumberstart;
    }

    public void setStreetnumberstart(String streetnumberstart) {
        this.streetnumberstart = streetnumberstart;
    }

    public String getStreetnumberend() {
        return streetnumberend;
    }

    public void setStreetnumberend(String streetnumberend) {
        this.streetnumberend = streetnumberend;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Route route = (Route) o;
        return Objects.equals(id, route.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
