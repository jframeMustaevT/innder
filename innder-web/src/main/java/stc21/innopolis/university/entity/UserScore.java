package sts21.innopolis.university.innder.entity;


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
