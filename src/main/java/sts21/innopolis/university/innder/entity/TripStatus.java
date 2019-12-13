package sts21.innopolis.university.innder.entity;


import lombok.Getter;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "trip_status")
@Getter
public class TripStatus {
    @Id
    //manual
    @Column(name = "id", nullable = false)
    private int id;

    @Column(name = "status", nullable = false)
    private String status;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "trip")
    private List<Trip> trip;

}

