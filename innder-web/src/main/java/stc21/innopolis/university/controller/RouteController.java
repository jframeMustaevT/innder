package stc21.innopolis.university.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import stc21.innopolis.university.entity.Route;
import stc21.innopolis.university.repository.RouteRepository;

import javax.transaction.Transactional;
import java.util.HashMap;
import java.util.Map;

@Controller
@Transactional
public class RouteController {

    private RouteRepository routeRepository;

    @Autowired
    public RouteController(RouteRepository routeRepository) {
        this.routeRepository = routeRepository;
    }

    @RequestMapping(value = "/create-route", method = RequestMethod.POST)
    @ResponseBody
    public Route set(@RequestBody Route route) {
        routeRepository.save(route);
        return route;
    }
    @RequestMapping(value = "/create-route")
    public ModelAndView root() {
        Map<String, Object> model = new HashMap<>();
        return new ModelAndView("create-route", model);
    }
}