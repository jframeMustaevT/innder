package stc21.innopolis.university.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import stc21.innopolis.university.dto.FoundedTrips;
import stc21.innopolis.university.dto.RequestedTrips;
import stc21.innopolis.university.entity.Trip;
import stc21.innopolis.university.entity.TripStatus;
import stc21.innopolis.university.entity.User;
import stc21.innopolis.university.repository.TripRepository;

import javax.transaction.Transactional;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

@Transactional
@Controller
public class TripController {

    private TripRepository tripRepository;

    @Autowired
    public TripController(TripRepository tripRepository) {
        this.tripRepository = tripRepository;
    }

    @RequestMapping(value = "/create-trip", method = RequestMethod.POST)
    @ResponseBody
    public void set(@RequestBody Trip trip) {
        User currentUser = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        trip.setOwner(currentUser);
        trip.setStatus(TripStatus.ACTIVE);
        tripRepository.save(trip);
    }

    @RequestMapping(value = "/create-trip")
    public ModelAndView root() {
        Map<String, Object> model = new HashMap<>();
        return new ModelAndView("create-trip", model);
    }

    @RequestMapping(value = "/search-trip")
    public ModelAndView searchTrip() {
        //Форма для поиска
        Map<String, Object> model = new HashMap<>();
        return new ModelAndView("search-trip", model);
    }
    @RequestMapping(value = "/trips", method = RequestMethod.POST)
    public ModelAndView getTrips(@RequestBody RequestedTrips requestedTrips){
        Collection<Trip> trips = tripRepository
                .findByRoute_StartCityAndRoute_EndCityAndStartDataTimeBetween(
                requestedTrips.getStartCity(),
                requestedTrips.getEndCity(),
                requestedTrips.getMinStartDataTime(),
                requestedTrips.getMaxStartDataTime());
        Collection<FoundedTrips> foundedTrips = trips
                .stream()
                .map(t -> {return new FoundedTrips(t);})
                .collect(Collectors.toList());
        Map<String, Object> model = new HashMap<>();
        model.put("foundedTrips", foundedTrips);
        return new ModelAndView("trips", model);
    }

}

