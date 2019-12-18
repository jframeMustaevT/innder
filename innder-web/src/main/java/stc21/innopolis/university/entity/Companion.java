package stc21.innopolis.university.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "companion")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Companion {

    @Id
    @GeneratedValue(generator = "COMPANION_GENERATOR", strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "COMPANION_GENERATOR", allocationSize = 1, sequenceName = "companion_id_seq")
    @Column(name = "id", nullable = false)
    private long id;

    @ManyToOne
    @JoinColumn(name = "trip_id")
    private Trip trip;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
}
