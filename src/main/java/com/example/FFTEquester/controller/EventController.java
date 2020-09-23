package com.example.FFTEquester.controller;

import com.example.FFTEquester.model.Equine;
import com.example.FFTEquester.model.Event;
import com.example.FFTEquester.model.EventType;
import com.example.FFTEquester.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;
import java.security.Principal;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;


@Controller
public class EventController extends AbstractController{






    @GetMapping("event/{eventId}")
    public String displayAllEvents(Model model) {
        List<String> events = new ArrayList<>();


        return "testing";
    }



    @GetMapping("add")
    public String processAddEventForm(Principal principal,
                                      Model model,
                                      Equine equine
                                      ) {
        addMyEquines(model, principal);
        Iterable<EventType> eventTypes = eventTypeRepository.findAll();
        addEvents(model, equine);
        model.addAttribute("eventTypes", eventTypes);

        return "redirect:";
    }

    @PostMapping("add")
    public String processAddEventForm(@ModelAttribute @Valid Event newEvent,
                                      Errors errors,
                                      Principal principal,
                                      Model model,
                                      Equine equine,
                                      @RequestParam int eventTypeId) {
        if (errors.hasErrors()) {
            return "redirect:";
        }
        addEvents(model, equine);
        String googlePrincipalName = principal.getName();
        User user = userRepository.findByGooglePrincipalName(googlePrincipalName);
        EventType newEventType = eventTypeRepository.findById(eventTypeId).get();
        Timestamp currentTime = new Timestamp(System.currentTimeMillis());
        newEvent.setTimeStamp(currentTime);
        newEvent.setUser(user);
        newEvent.setEventType(newEventType);
        eventRepository.save(newEvent);
        return "redirect:";
    }

}