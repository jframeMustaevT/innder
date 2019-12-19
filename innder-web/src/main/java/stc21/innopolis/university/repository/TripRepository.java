package stc21.innopolis.university.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import stc21.innopolis.university.entity.Trip;

public interface TripRepository extends PagingAndSortingRepository <Trip, Long>{
}
