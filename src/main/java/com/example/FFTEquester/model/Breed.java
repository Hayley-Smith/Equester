package com.example.FFTEquester.model;

import javax.persistence.Entity;

@Entity
public class Breed extends AbstractEntity{

    private String breed;

    public Breed() {
    }

    public Breed(String breed) {
        this.breed = breed;
    }

    public String getBreed() {
        return breed;
    }

    public void setBreed(String breed) {
        this.breed = breed;
    }
}
