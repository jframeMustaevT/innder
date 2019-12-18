package stc21.innopolis.university.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;

import javax.persistence.*;

@Entity
@Table(name = "authority")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Authority implements GrantedAuthority {

    @Id
    @GeneratedValue(generator = "AUTHORITY_GENERATOR", strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "AUTHORITY_GENERATOR", allocationSize = 1, sequenceName = "authority_id_seq")
    @Column(name = "id", nullable = false)
    private long id;

    @Column(name = "authority", nullable = false)
    private String authority;

    @ManyToOne(fetch = FetchType.LAZY)
    private User user;
}
