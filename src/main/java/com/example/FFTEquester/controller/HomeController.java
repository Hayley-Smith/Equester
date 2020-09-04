package com.example.FFTEquester.controller;

import com.example.FFTEquester.data.UserRepository;
import com.example.FFTEquester.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.security.Principal;

@Controller
public class HomeController {

    @Autowired
    UserRepository userRepository;

    @GetMapping("/")
    @ResponseBody
    public String renderLandingPage(Model model){

        return "Welcome To Equester";
    }

    @GetMapping("/index")
    public String renderHomePage(Model model){

        return "index";
    }

    @GetMapping("/userProfile")
    public String renderUserProfile(Model model){

        return "userProfile";
    }


    @GetMapping("/add")
    @ResponseBody
    public String restricted(){
        return "Welcome to Equester";
    }

    @RequestMapping(value = "/user")
    public String user(Principal principal) {
        String googlePrincipalName = principal.getName();
        if (!userRepository.existsByGooglePrincipalName(googlePrincipalName)){
            User newUser = new User(googlePrincipalName);
            userRepository.save(newUser);
        }


        return "redirect:";
    }

    @RequestMapping(value = "/test")
    public String currentUserNameSimple(HttpServletRequest request) {
        Principal principal = request.getUserPrincipal();
        return principal.getName();
    }


}
