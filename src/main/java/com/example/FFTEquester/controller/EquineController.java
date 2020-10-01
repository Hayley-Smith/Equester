package com.example.FFTEquester.controller;

import com.example.FFTEquester.model.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.security.Principal;
import java.sql.Timestamp;


@Controller
public class EquineController extends AbstractController{

    public Model addToEquineModel(Model model,
                                  int equineId,
                                  Principal principal
                                  ){
        Iterable<Event> events = eventRepository.findByEquineId(equineId);
        Equine equine = equineRepository.findById(equineId).get();

        //add event form
        Iterable<EventType> eventTypes = eventTypeRepository.findAll();
        Event event = new Event();

        //adds to model
        addEvents(model, equine);
        addMyEquines(model, principal);
        model.addAttribute("equineId", equineId);
        model.addAttribute("eventTypes", eventTypes);
        model.addAttribute("event", event);
        model.addAttribute("equine", equineRepository.findById(equineId).get());
        model.addAttribute(new Event());

        return model;
    };


    @GetMapping("/editEquineProfile")
    public String renderEditEquineProfileForm(Model model,
                                              Principal principal){
        addMyEquines(model, principal);
        Equine equine = new Equine();
        model.addAttribute("equine", equine);
        Iterable<Sex> sexes = sexRepository.findAll();
        Iterable<Breed> breeds = breedRepository.findAll();
        Iterable<Color> colors = colorRepository.findAll();


        model.addAttribute("sexes", sexes);
        model.addAttribute("breeds", breeds);
        model.addAttribute("colors", colors);

        return "editEquineProfile";
    }

    @PostMapping("/editEquineProfile")
    public String processAddEquineForm(@ModelAttribute("equine") @Valid Equine newEquine,
                                       Errors errors,
                                       @RequestParam int sexId,
                                       @RequestParam int breedId,
                                       @RequestParam int colorId,
                                       Principal principal,
                                       Model model) {
        if (errors.hasErrors()) {
            return "editEquineProfile";
        }
        User user = getUserFromPrincipal(principal);
        addMyEquines(model, principal);

        Sex newSex = sexRepository.findById(sexId).get();
        Breed newBreed = breedRepository.findById(breedId).get();
        Color newColor = colorRepository.findById(colorId).get();

        newEquine.setUser(user);
        newEquine.setSex(newSex);
        newEquine.setBreed(newBreed);
        newEquine.setColor(newColor);
        equineRepository.save(newEquine);
        return "index";
    }

    @GetMapping("equine/{equineId}")
    public String displayEquineProfile(Model model,
                                       @PathVariable int equineId,
                                       Principal principal){
        addToEquineModel(model, equineId, principal);

        return "testing";
    }


    @PostMapping("equine/{equineId}")
    public String processAddEventForm(@ModelAttribute @Valid Event newEvent,
                                      @ModelAttribute @Valid EventType newEventType,
                                      Errors errors,
                                      Principal principal,
                                      Model model,
                                      @PathVariable int equineId,
                                      @RequestParam int eventTypeId) {
        if (errors.hasErrors()) {
            return "redirect:";
        }
        System.out.println("Hello from the event form");
        //process new event
        Equine equine = equineRepository.findById(equineId).get();
        addEvents(model, equine);
        String googlePrincipalName = principal.getName();
        User user = userRepository.findByGooglePrincipalName(googlePrincipalName);
        Timestamp currentTime = new Timestamp(System.currentTimeMillis());
        newEvent.setTimeStamp(currentTime);
        newEvent.setUser(user);
        EventType eventType = eventTypeRepository.findById(eventTypeId).get();
        newEvent.setEventType(eventType);
        newEvent.setEquine(equine);
        eventRepository.save(newEvent);

        //load equine page
        addToEquineModel(model, equineId, principal);

        return "testing";
    }

    @GetMapping("/delete/{equineId}")
    public String deleteEquine(Model model,
                               @PathVariable int equineId,
                               Principal principal){
        Equine equine = equineRepository.findById(equineId).get();
        equineRepository.delete(equine);
        return "redirect:";
    }

    @GetMapping("/delete/{eventId}")
    public String deleteEvent(Model model,
                               @PathVariable int eventId,
                               Principal principal){
        Event event = eventRepository.findById(eventId).get();
        eventRepository.delete(event);
        return "redirect:";
    }

    }
