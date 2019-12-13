package sts21.innopolis.university.innder.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;
@Entity
@Table (name = "trip")
@Getter
@Setter
public class Trip {
    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue (generator = "TRIP-GENERATOR", strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "TRIP_GENERATOR", allocationSize = 1, sequenceName = "trip_id_seq")
    private  long id;

    @Column(name = "start_data_time")
    private  long StartDataTime;

    @Column(name = "finish_data_time")
    private  long FinishDataTime;

    @OneToMany(fetch = FetchType.LAZY)
    @JoinColumn(name = "trip_status_id")
    private List<TripStatus> status;

    @Column(name = "descrpition")
    private String Descriptin;

    @Column(name = "cost")
    private int Cost;

    @Column(name = "vehicle")
    private String Vehicle;

    @Column(name = "rout", nullable = false)
    private long Rout;



}


