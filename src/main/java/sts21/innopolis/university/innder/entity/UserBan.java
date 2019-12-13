package sts21.innopolis.university.innder.entity;

//CREATE TABLE user_ban (
//        id        serial NOT NULL,
//        banner_id bigint NOT NULL,
//        banned_id bigint NOT NULL,
//        CONSTRAINT user_ban_pk PRIMARY KEY (id)


import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.Banner;

import javax.persistence.*;
import java.util.List;

@Entity
@Table (name = "user_ban")
@Getter
@Setter

public class UserBan {
    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(generator = "USER_BAN_ID-GENERATOR", strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "USER_BAN_ID_GENERATOR", allocationSize = 1, sequenceName = "user_ban_id_seq")
    private  long id;

    @OneToMany(fetch = FetchType.LAZY)
    @JoinColumn(name = "banned_id")
    private List<User> banner;

    @ManyToOne (fetch = FetchType.LAZY)
    @JoinColumn (name = "banned_id")
    private UserBan userBan;


}


