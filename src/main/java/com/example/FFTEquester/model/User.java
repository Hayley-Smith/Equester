package com.example.FFTEquester.model;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;

@Entity
public class User extends AbstractEntity{


    private String googlePrincipalName;

    @OneToMany(mappedBy = "user")
    private List<Equine> equines =new ArrayList<Equine>();

    public User() {}

    public User(String googlePrincipalName, List<Equine> equines) {
        this.googlePrincipalName = googlePrincipalName;
        this.equines = equines;
    }

    public User(String googlePrincipalName) {
        this.googlePrincipalName = googlePrincipalName;
    }
}