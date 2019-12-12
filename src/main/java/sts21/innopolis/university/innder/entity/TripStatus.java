package sts21.innopolis.university.innder.entity;


import lombok.Getter;

import javax.persistence.*;

@Entity
@Table(name = "trip_status")
@Getter
public enum TripStatus {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id", nullable = false)
    private int id;

    @Column(name = "status", nullable = false)
    private String status;

}

