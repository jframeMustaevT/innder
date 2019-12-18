package stc21.innopolis.university.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;
import stc21.innopolis.university.entity.Route;

@Repository
public interface RouteRepository extends PagingAndSortingRepository<Route, Long> {


}