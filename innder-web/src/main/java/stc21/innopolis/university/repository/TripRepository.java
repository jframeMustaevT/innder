package stc21.innopolis.university.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import stc21.innopolis.university.entity.Trip;
import stc21.innopolis.university.entity.TripStatus;

import java.util.Collection;

public interface TripRepository extends PagingAndSortingRepository <Trip, Long>{

    public Collection<Trip> findByRoute_StartCityAndRoute_EndCityAndStartDataTimeBetween(
            String startCity,
            String endCity,
            long minStartDataTime,
            long maxStartDataTime
    );

}
