package stc21.innopolis.university.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "route")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Route {
    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(generator = "ROUTE_GENERATOR", strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "ROUTE_GENERATOR", allocationSize = 1, sequenceName = "route_id_seq")
    private long id;

    @Column (name = "start_city", nullable = false)
    private String startCity;

    @Column (name = "start_street")
    private String startStreet;

    @Column (name = "start_street_number")
    private String startStreetNumber;

    @Column (name = "end_city", nullable = false)
    private String endCity;

    @Column (name = "end_street")
    private String endStreet;

    @Column (name = "end_street_number")
    private String endStreetNumber;
}