package com.example.FFTEquester.controller;

import com.example.FFTEquester.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.security.Principal;

@Controller
public class HomeController extends AbstractController {
    @GetMapping("/")
    public String renderLandingPage(Model model,
                                    Principal principal){
        addMyEquines(model, principal);
        return "landingPage";
    }

    @GetMapping("/index")
    public String renderHomePage(Model model,
                                 Principal principal){
        String googlePrincipalName = principal.getName();
        if (!userRepository.existsByGooglePrincipalName(googlePrincipalName)){
            User newUser = new User(googlePrincipalName);
            userRepository.save(newUser);
        }
        addMyEquines(model, principal);
        return "index";
    }

    @GetMapping("/userProfile")
    public String renderUserProfile(Model model,
                                    Principal principal){
        addMyEquines(model, principal);
        return "userProfile";
    }






}
