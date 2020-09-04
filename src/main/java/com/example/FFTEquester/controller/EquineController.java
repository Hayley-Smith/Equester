package com.example.FFTEquester.controller;

import com.example.FFTEquester.data.*;
import com.example.FFTEquester.model.Equine;
import com.example.FFTEquester.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.security.Principal;
import java.util.Optional;


/*
 TO DO: create mapping for edit equine profile form
 TO DO: create mapping for process edit equine profile form
 TO DO: create mapping for viewing equine profile
 TODO: create mapping for deleting equine profile
 TODO: create mapping for Creating equine profile
*/


@Controller
public class EquineController {

    @Autowired
    EventRepository eventRepository;

    @Autowired
    UserRepository userRepository;

    @Autowired
    BreedRepository breedRepository;

    @Autowired
    SexRepository sexRepository;

    @Autowired
    EquineRepository equineRepository;

    private static final String userSessionKey = "user";


    @RequestMapping("editEquineProfile")
    public String renderEditEquineProfileForm(Model model){
        model.addAttribute(new Equine());

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


    @PostMapping("editEquineProfile")
    public String processAddSnippetForm(@ModelAttribute @Valid Equine newEquine,
                                        Errors errors, Principal principal) {
        if (errors.hasErrors()) {
            return "editEquineProfile";
        }

        String googlePrincipalName = principal.getName();
        User user = userRepository.findByGooglePrincipalName(googlePrincipalName);

        newEquine.setUser(user);
        equineRepository.save(newEquine);
        return "testing";
    }

    @GetMapping("equineProfile")
    public String renderEquineProfile(Model model){
        model.addAttribute(new Equine());

        return "equineProfile";
    }

    @GetMapping("equineProfilePrivate")
    public String renderEquineProfilePrivate(Model model){
        model.addAttribute(new Equine());

        return "equineProfilePrivate";
    }

    @GetMapping("equineProfilePublic")
    public String renderEquineProfilePublic(Model model){
        model.addAttribute(new Equine());

        return "equineProfilePublic";
    }

    @GetMapping("testing")
    public String renderTesting(Model model){
        model.addAttribute(new Equine());

        return "testing";
    }


    }
