package com.example.FFTEquester.model;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

@Entity
public class Breed extends AbstractEntity{

    private String breed;

    @ManyToOne
    private Type type;

    public Breed() {
    }

    public Breed(String breed, Type type) {
        this.breed = breed;
        this.type = type;
    }

    public String getBreed() {
        return breed;
    }

    public void setBreed(String breed) {
        this.breed = breed;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }
}
