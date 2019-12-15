package stc21.innopolis.university.entity;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Table (name = "compaion")
@Getter
@Setter
public class Companion {

    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(generator = "COMPANION_GENERATOR", strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "COMPANION_GENERATOR", allocationSize = 1, sequenceName = "companion_id_seq")
    private long id;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "trip_id")
    private Rout rout;

    @OneToMany(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private List<User> user;
}
