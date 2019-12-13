package sts21.innopolis.university.innder.entity;

//CREATE TABLE user_score (
//        id          serial NOT NULL,
//        user_id     bigint NOT NULL,
//        score       int,
//        count       int DEFAULT '1',
//        CONSTRAINT user_score_pk PRIMARY KEY (id)


import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Table (name = "user_score")
@Getter
@Setter

public class UserScore {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id", nullable = false)
    private Long id;

    @OneToMany(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private List<User> User;

    @Column(name = "score")
    private int Score;

    @Column(name = "count", nullable = false) //default = 1
    private int count;


}
