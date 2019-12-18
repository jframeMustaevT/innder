package stc21.innopolis.university.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import stc21.innopolis.university.entity.Trip;
import stc21.innopolis.university.entity.TripStatus;
import stc21.innopolis.university.entity.User;
import stc21.innopolis.university.repository.TripRepository;

import javax.transaction.Transactional;
import java.util.HashMap;
import java.util.Map;

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
        User currentUser = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        trip.setOwner(currentUser);
        trip.setStatus(TripStatus.ACTIVE);
        tripRepository.save(trip);
    }
    @RequestMapping(value = "/create-trip")
    public ModelAndView root() {
        Map<String, Object> model = new HashMap<>();
        return new ModelAndView("create-trip", model);
    }
}

