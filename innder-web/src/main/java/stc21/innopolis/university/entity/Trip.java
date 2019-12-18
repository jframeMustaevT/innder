package stc21.innopolis.university.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Table(name = "trip")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Trip {
    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(generator = "TRIP_GENERATOR", strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "TRIP_GENERATOR", allocationSize = 1, sequenceName = "trip_id_seq")
    private long id;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "owner_id")
    private User owner;

    @Column(name = "start_data_time")
    private long startDataTime;

    @Column(name = "finish_data_time")
    private long finishDataTime;

    @Column(name = "status")
    @Enumerated(value = EnumType.STRING)
    private TripStatus status;

    @Column(name = "type")
    @Enumerated(value = EnumType.STRING)
    private TripType type;

    @Column(name = "description")
    private String description;

    @Column(name = "cost")
    private String cost;

    @Column(name = "max_companions")
    private int maxCompanions;

    @OneToOne(optional = false)
    @JoinColumn(name = "route_id", referencedColumnName = "id")
    private Route route;

    @OneToMany(mappedBy = "trip", fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
    private Collection<Companion> companions;

}


