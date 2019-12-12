package sts21.innopolis.university.innder.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table (name = "trip")
@Getter
@Setter
public class Trip {
    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue (strategy = GenerationType.AUTO)
    private  long id;

    @Column(name = "start_data_time")
    private  long StartDataTime;

    @Column(name = "finish_data)time")
    private  long FinishDataTime;

    @OneToOne(targetEntity = TripStatus.class)
    @JoinColumn(name = "status")
    private status status;

    @Column(name = "type_trip")
    private long TypeTrip;

    @Column(name = "descrpition")
    private String Descriptin;

    @Column(name = "cost")
    private int Cost;

    @Column(name = "vehicle")
    private String Vehicle;

    @Column(name = "rout", nullable = false)
    private long Rout;



}


