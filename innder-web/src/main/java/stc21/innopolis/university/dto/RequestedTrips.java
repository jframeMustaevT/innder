package stc21.innopolis.university.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RequestedTrips {

    private String startCity;

    private String endCity;

    private long minStartDataTime;

    private long maxStartDataTime;
}
