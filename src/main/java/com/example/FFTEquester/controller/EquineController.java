package com.example.FFTEquester.controller;

import com.example.FFTEquester.model.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.security.Principal;



@Controller
public class EquineController extends AbstractController{


    @GetMapping("/editEquineProfile")
    public String renderEditEquineProfileForm(Model model, Principal principal){
        addMyEquines(model, principal);
        Equine equine = new Equine();
        model.addAttribute("equine", equine);
        Iterable<Sex> sexes = sexRepository.findAll();
        Iterable<Breed> breeds = breedRepository.findAll();

        model.addAttribute("sexes", sexes);
        model.addAttribute("breeds", breeds);

        return "editEquineProfile";
    }

    @PostMapping("/editEquineProfile")
    public String processAddEquineForm(@ModelAttribute("equine") @Valid Equine newEquine, Errors errors,
                                       @RequestParam int breedId, @RequestParam int sexId,
                                       Principal principal, Model model) {
        if (errors.hasErrors()) {
            return "editEquineProfile";
        }
        User user = getUserFromPrincipal(principal);
        addMyEquines(model, principal);
        System.out.println(breedId);
        Sex newSex = sexRepository.findById(sexId).get();
        Breed newBreed = breedRepository.findById(breedId).get();

        newEquine.setUser(user);
        newEquine.setSex(newSex);
        newEquine.setBreed(newBreed);
        equineRepository.save(newEquine);
        return "index";
    }

    @GetMapping("equine/{equineId}")
    public String displayEquineProfile(Model model, @PathVariable int equineId, Principal principal){
        //System.out.println("Testing");
        addMyEquines(model, principal);
        model.addAttribute("equine", equineRepository.findById(equineId).get());
        model.addAttribute(new Event());
        Iterable<EventType> eventTypes = eventTypeRepository.findAll();
        model.addAttribute("eventTypes", eventTypes);
        Iterable<Event> events = eventRepository.findByEquineId(equineId);

        return "testing";
    }


    @GetMapping("testing")
    public String renderTesting(Model model, Principal principal, Equine equine){
        int id = 15;
        String googlePrincipalName = principal.getName();
        addMyEquines(model, principal);
        model.addAttribute("equine", equineRepository.findById(id).get());
        model.addAttribute(new Event());
        Iterable<EventType> eventTypes = eventTypeRepository.findAll();

        model.addAttribute("eventTypes", eventTypes);
        return "testing";
    }

    }
