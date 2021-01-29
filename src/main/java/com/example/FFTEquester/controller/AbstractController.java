package com.example.FFTEquester.controller;

import com.example.FFTEquester.data.*;
import com.example.FFTEquester.model.Equine;
import com.example.FFTEquester.model.EventType;
import com.example.FFTEquester.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;

import javax.persistence.MappedSuperclass;
import javax.servlet.http.HttpSession;
import java.security.Principal;
import java.util.Optional;

@MappedSuperclass
public abstract class AbstractController {

    @Autowired
    EventRepository eventRepository;

    @Autowired
    ColorRepository colorRepository;

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

    @Autowired
    TypeRepository typeRepository;

    private static final String userSessionKey = "user";

    public void addMyEquines(Model model,
                             Principal principal){
        User user = getUserFromPrincipal(principal);
        model.addAttribute("myEquines", equineRepository.findByUser(user));
    }

    public User getUserFromPrincipal(Principal principal){
        String googlePrincipalName = principal.getName();
        System.out.println(googlePrincipalName);
        User user = userRepository.findByGooglePrincipalName(googlePrincipalName);
        return user;
    }

    public void addEvents(Model model,
                          Equine equine,
                          int eventTypeId){
        if (eventTypeId == 0){
            model.addAttribute("myEvents", eventRepository.findByEquineOrderByTimeStampDesc(equine));
        } else {
            EventType eventType = eventTypeRepository.findById(eventTypeId).get();
            model.addAttribute("myEvents", eventRepository.findByEquineAndEventTypeOrderByTimeStampDesc(equine, eventType));
        };
    }


    public String booleanToString(boolean trueOrFalse ) {
        return trueOrFalse ? "Yes" : "No";
    }


    User getUserFromSession(HttpSession session) {
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


}
