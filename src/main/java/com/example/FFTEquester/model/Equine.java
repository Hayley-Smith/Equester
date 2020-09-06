package com.example.FFTEquester.model;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.validation.constraints.Size;


@Entity
public class Equine extends AbstractEntity{

    @Size(max = 100)
    private String equineName;

    private int yearOfBirth;

    private int height;

    private int weight;

    @ManyToOne
    private Sex sex;

    @ManyToOne
    private User user;

    private Boolean inFoal = false;

    private Boolean foalAtSide = false;

    private Boolean atStud = false;

    @Size(max = 100)
    private String color;

    @Size(max = 255)
    private String description;

    private Boolean forSale = false;

    private Boolean forLease = false;

    @ManyToOne
    private Breed breed;

    public Equine() {
    }

    public Equine(@Size(max = 100) String equineName, int yearOfBirth, int height, int weight,
                  Sex sex, User user, Boolean inFoal, Boolean foalAtSide, Boolean atStud,
                  @Size(max = 100) String color, @Size(max = 255) String description,
                  Boolean forSale, Boolean forLease, Breed breed) {
        this.equineName = equineName;
        this.yearOfBirth = yearOfBirth;
        this.height = height;
        this.weight = weight;
        this.sex = sex;
        this.user = user;
        this.inFoal = inFoal;
        this.foalAtSide = foalAtSide;
        this.atStud = atStud;
        this.color = color;
        this.description = description;
        this.forSale = forSale;
        this.forLease = forLease;
        this.breed = breed;
    }

    public String getEquineName() {
        return equineName;
    }

    public void setEquineName(String equineName) {
        this.equineName = equineName;
    }

    public int getYearOfBirth() {
        return yearOfBirth;
    }

    public void setYearOfBirth(int yearOfBirth) {
        this.yearOfBirth = yearOfBirth;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public Sex getSex() {
        return sex;
    }

    public void setSex(Sex sex) {
        this.sex = sex;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Boolean getInFoal() {
        return inFoal;
    }

    public void setInFoal(Boolean inFoal) {
        this.inFoal = inFoal;
    }

    public Boolean getFoalAtSide() {
        return foalAtSide;
    }

    public void setFoalAtSide(Boolean foalAtSide) {
        this.foalAtSide = foalAtSide;
    }

    public Boolean getAtStud() {
        return atStud;
    }

    public void setAtStud(Boolean atStud) {
        this.atStud = atStud;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Boolean getForSale() {
        return forSale;
    }

    public void setForSale(Boolean forSale) {
        this.forSale = forSale;
    }

    public Boolean getForLease() {
        return forLease;
    }

    public void setForLease(Boolean forLease) {
        this.forLease = forLease;
    }

    public Breed getBreed() {
        return breed;
    }

    public void setBreed(Breed breed) {
        this.breed = breed;
    }
}