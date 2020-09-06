package com.example.FFTEquester.controller;

import com.example.FFTEquester.data.*;
import com.example.FFTEquester.model.Breed;
import com.example.FFTEquester.model.Equine;
import com.example.FFTEquester.model.Sex;
import com.example.FFTEquester.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.security.Principal;
import java.util.Optional;



@Controller
public class EquineController {

    @Autowired
    EventRepository eventRepository;

    @Autowired
    EventTypeRepository eventTypeRepository;

    @Autowired
    UserRepository userRepository;

    @Autowired
    BreedRepository breedRepository;

    @Autowired
    SexRepository sexRepository;

    @Autowired
    EquineRepository equineRepository;

    private static final String userSessionKey = "user";

    @GetMapping("/editEquineProfile")
    public String renderEditEquineProfileForm(Model model){
        Equine equine = new Equine();
        model.addAttribute("equine", equine);
        Iterable<Sex> sexes= sexRepository.findAll();
        Iterable<Breed> breeds = breedRepository.findAll();

        model.addAttribute("sexes", sexes);
        model.addAttribute("breeds", breeds);

        return "editEquineProfile";
    }

    public User getUserFromSession(HttpSession session) {
        String googlePrincipalName = (String) session.getAttribute(userSessionKey);
        if (googlePrincipalName == null) {
            return null;
        }

        Optional<User> user = Optional.ofNullable(userRepository.findByGooglePrincipalName(googlePrincipalName));

        if (user.isEmpty()) {
            return null;
        }

        return user.get();
    }


    @PostMapping("/editEquineProfile")
    public String processAddEquineForm(@ModelAttribute("equine") @Valid Equine newEquine, Errors errors,
                                       @RequestParam int breedId, @RequestParam int sexId,
                                       Principal principal) {
        if (errors.hasErrors()) {
            return "editEquineProfile";
        }

        System.out.println(breedId);

        String googlePrincipalName = principal.getName();
        User user = userRepository.findByGooglePrincipalName(googlePrincipalName);

        Sex newSex = sexRepository.findById(sexId).get();
        Breed newBreed = breedRepository.findById(breedId).get();

        newEquine.setUser(user);
        newEquine.setSex(newSex);
        newEquine.setBreed(newBreed);
        equineRepository.save(newEquine);
        return "index";
    }



    @GetMapping("equineProfilePrivate")
    public String renderEquineProfilePrivate(Model model){
        return "equineProfilePrivate";
    }

    @GetMapping("equineProfilePublic")
    public String renderEquineProfilePublic(Model model){
        return "equineProfilePublic";
    }

    @GetMapping("testing")
    public String renderTesting(Model model){
        int id = 11;
        model.addAttribute("equine", equineRepository.findById(id).get());
       //model.addAttribute("equine", equineRepository.findById());
        return "testing";
    }


    }
