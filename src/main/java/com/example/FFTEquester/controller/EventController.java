package com.example.FFTEquester.controller;

import com.example.FFTEquester.data.EventRepository;
import com.example.FFTEquester.data.UserRepository;
import com.example.FFTEquester.model.Event;
import com.example.FFTEquester.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.security.Principal;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Controller
public class EventController {

    @Autowired
    EventRepository eventRepository;

    @Autowired
    UserRepository userRepository;

    private static final String userSessionKey = "user";


    @GetMapping
    public String displayAllEvents(Model model) {
        List<String> events = new ArrayList<>();

        return "addEvent";
    }

    @RequestMapping("add")
    public String displayAddEventForm(Model model) {
        EventRepository events;
        model.addAttribute(new Event());



        return "addEvent";
    }

    @PostMapping("add")
    public String processAddEventForm(@ModelAttribute @Valid Event newEvent,
                                      Errors errors, HttpServletRequest request, Principal principal) {

        if (errors.hasErrors()) {
            return "addEvent";
        }
        Timestamp currentTime = new Timestamp(System.currentTimeMillis());
        newEvent.setTimeStamp(currentTime);

        HttpSession session = request.getSession();
        User user = getUserFromSession(session);
        newEvent.setUser(user);
       // eventRepository.save(newEvent);


        return "redirect:";
    }

    private User getUserFromSession(HttpSession session) {
        Integer userId = (Integer) session.getAttribute(userSessionKey);
        if (userId == null) {
            return null;
        }

      Optional<User> user = userRepository.findById(userId);

        if (user.isEmpty()) {
            return null;
        }

        return user.get();
    }

    @PostMapping("deleteEvent")
    public String deleteEvent(@ModelAttribute @Valid Integer userId,
                              HttpServletRequest request) {
        HttpSession session = request.getSession();
        User user = getUserFromSession(session);
      //  eventRepository.deleteEventById();
        return "redirect:";
    }

}