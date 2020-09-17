package com.example.FFTEquester.controller;

import com.example.FFTEquester.model.Equine;
import com.example.FFTEquester.model.Event;
import com.example.FFTEquester.model.User;
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


@Controller
public class EventController extends AbstractController{




    public void addEvents(Model model, Principal principal, Equine equine){
        User user = getUserFromPrincipal(principal);
        model.addAttribute("myEvents", eventRepository.findByEquine(equine));
    }

    @GetMapping
    public String displayAllEvents(Model model) {
        List<String> events = new ArrayList<>();


        return "testing";
    }

    @RequestMapping("add")
    public String displayAddEventForm(Model model) {



        return "redirect:";
    }

    @PostMapping("add")
    public String processAddEventForm(@ModelAttribute @Valid Event newEvent,
                                      Errors errors, Principal principal, Model model, Equine equine) {

        if (errors.hasErrors()) {
            return "addEvent";
        }
        Timestamp currentTime = new Timestamp(System.currentTimeMillis());
        newEvent.setTimeStamp(currentTime);
        addEvents(model, principal, equine);
        String googlePrincipalName = principal.getName();
        User user = userRepository.findByGooglePrincipalName(googlePrincipalName);
        newEvent.setUser(user);

        eventRepository.save(newEvent);


        return "redirect:";
    }


    @PostMapping("deleteEvent")
    public String deleteEvent(@ModelAttribute @Valid Integer userId,
                              HttpServletRequest request) {
        HttpSession session = request.getSession();
        User user = getUserFromSession(session);
        return "redirect:";
    }

}