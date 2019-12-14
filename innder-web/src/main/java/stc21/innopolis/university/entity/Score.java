package sts21.innopolis.university.innder.entity;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table (name = "Score")
@Setter
@Getter
public class Score {
    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(generator = "SCORE-GENERATOR", strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "SCORE_GENERATOR", allocationSize = 1, sequenceName = "score_id_seq")
    private  long id;

}
