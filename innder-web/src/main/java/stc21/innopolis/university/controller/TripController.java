package stc21.innopolis.university.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import stc21.innopolis.innderbot.interaction.innder.InteractionWithInnder;
import stc21.innopolis.university.dto.FoundedTrips;
import stc21.innopolis.university.dto.RequestedTrips;
import stc21.innopolis.university.dto.Subscribe;
import stc21.innopolis.university.entity.Trip;
import stc21.innopolis.university.entity.TripStatus;
import stc21.innopolis.university.entity.User;
import stc21.innopolis.university.interaction.bot.InteractionWithBot;
import stc21.innopolis.university.repository.TripRepository;

import javax.transaction.Transactional;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

@Transactional
@Controller
public class TripController {

    private TripRepository tripRepository;

    private InteractionWithBot bot;


    @Autowired
    public TripController(TripRepository tripRepository, InteractionWithBot bot) {
        this.tripRepository = tripRepository;
        this.bot = bot;
    }

    @RequestMapping(value = "/create-trip", method = RequestMethod.POST)
    @ResponseBody
    public String set(@RequestBody Trip trip) {
        User currentUser = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        trip.setOwner(currentUser);
        trip.setStatus(TripStatus.ACTIVE);
        tripRepository.save(trip);
        if (currentUser.getTelegramChatId() == null || currentUser.getTelegramChatId().trim().length() == 0) {
            return "Пожалуйства начните беседу с нашим ботом @InnderBot, чтобы он имел возможность отправлять вам опевещения о новых попутчиках.";
        }

        return "Спасибо за регистрацию поездки!";
    }

    @RequestMapping(value = "/create-trip")
    public ModelAndView root() {
        Map<String, Object> model = new HashMap<>();
        return new ModelAndView("create-trip", model);
    }

    @RequestMapping(value = "/search-trip")
    public ModelAndView searchTrip() {
        Map<String, Object> model = new HashMap<>();
        return new ModelAndView("search-trip", model);
    }

    @RequestMapping(value = "/trips")
    public ModelAndView trips() {
        Map<String, Object> model = new HashMap<>();
        return new ModelAndView("trips", model);
    }

    @RequestMapping(value = "/search-trip", method = RequestMethod.POST)
    @ResponseBody
    public Collection<FoundedTrips> getTrips(@RequestBody RequestedTrips requestedTrips) {
        Collection<Trip> trips = tripRepository
                .findByRoute_StartCityAndRoute_EndCityAndStartDataTimeBetween(
                        requestedTrips.getStartCity(),
                        requestedTrips.getEndCity(),
                        requestedTrips.getMinStartDataTime(),
                        requestedTrips.getMaxStartDataTime());
        Collection<FoundedTrips> foundedTrips = trips
                .stream()
                .map(t -> {
                    return new FoundedTrips(t);
                })
                .collect(Collectors.toList());
        return foundedTrips;
    }

    @RequestMapping(value = "/trips", method = RequestMethod.POST)
    @ResponseBody
    public Long subscribe(@RequestBody Subscribe sub) {
        User currentUser = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if (sub != null && sub.getId() != null) {
            Optional<Trip> trip = tripRepository.findById(sub.getId());
            if (trip.isPresent()
                    && trip.get().getOwner() != null
                    && trip.get().getOwner().getTelegramChatId().trim().length() != 0) {
                bot.sendMessage(trip.get().getOwner().getTelegramChatId(), "На вашу поездку подписался @" + currentUser.getTelegramName() + "! Поговорите с ним о будущей поездке");
            }
        }
        return sub.getId();
    }
}

