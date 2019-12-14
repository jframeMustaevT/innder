package sts21.innopolis.university.innder.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;


@Entity
@Table (name = "user")
@Getter
@Setter
public class User {
    @Id
    @GeneratedValue (generator = "USER_GENERATOR", strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "USER_GENERATOR", allocationSize = 1, sequenceName = "trip_id_seq")
    @Column(name = "id", nullable = false)
    private Long id;

//    @OneToMany(fetch = FetchType.LAZY)
//    @JoinColumn(name = "banner")
//    private List<User> userBanner;
//
//    @ManyToOne (fetch = FetchType.LAZY)
//    @JoinColumn (name = "banned")
//    private User userBaned;

    @Column (name = "email", nullable = false, unique = true)
    private String email;

    @Column (name = "phone", nullable = false)
    private int Phone;

    @Column (name = "telegram_name")
    private String TelegramName;

    @Column (name = "status", nullable = false)
    private String Status;

    @Column (name = "first_name", nullable = false)
    private String FirstName;

    @Column (name = "last_name")
    private String LastName;

    @Column (name = "enable", nullable = false) //columnDefinition = true
    private boolean Enable ; // =true

    @Column (name = "account_non_expired", nullable = false)
    private boolean AccountNonExpired ; // =true

    @Column (name = "account_non_locked", nullable = false)
    private boolean AccountNonLocked ; // =true

    @Column (name = "credentials_non_expired", nullable = false)
    private boolean CredentialsNonExpired ; // =true


}
