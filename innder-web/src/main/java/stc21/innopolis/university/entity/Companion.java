package sts21.innopolis.university.innder.entity;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table (name = "compaion")
@Getter
@Setter
public class Companion {

    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(generator = "COMPANIOn-GENERATOR", strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "COMPANION_GENERATOR", allocationSize = 1, sequenceName = "companion_id_seq")
    private  long id;
}
