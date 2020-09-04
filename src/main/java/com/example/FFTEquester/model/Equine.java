package com.example.FFTEquester.model;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;


@Entity
public class Equine extends AbstractEntity{

    @NotBlank
    @Size(max = 100)
    private String equineName;


    @NotBlank
    @Size(max = 4)
    private int yearOfBirth;

    @NotBlank
    @Size(max = 10)
    private int height;

    @NotBlank
    @Size(max = 255)
    private int weight;

    @NotBlank
    @ManyToOne
    private Sex sex;


    @ManyToOne
    private User user;

    private boolean inFoal;

    private boolean foalAtSide;

    private boolean atStud;

    @NotBlank
    @Size(max = 100)
    private String color;

    @NotBlank
    @Size(max = 255)
    private String description;

    private boolean forSale;

    private boolean forLease;

    @NotBlank
    @ManyToOne
    private Breed breed;

    public Equine() {
    }

    public Equine(@NotBlank @Size(max = 100) String equineName, @NotBlank @Size(max = 4) int yearOfBirth, @NotBlank @Size(max = 10) int height,
                  @NotBlank @Size(max = 255) int weight, @NotBlank Sex sex, User user, boolean inFoal, boolean foalAtSide, boolean atStud,
                  @NotBlank @Size(max = 100) String color, @NotBlank @Size(max = 255) String description, boolean forSale, boolean forLease,
                  @NotBlank Breed breed) {
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

    public boolean isInFoal() {
        return inFoal;
    }

    public void setInFoal(boolean inFoal) {
        this.inFoal = inFoal;
    }

    public boolean isFoalAtSide() {
        return foalAtSide;
    }

    public void setFoalAtSide(boolean foalAtSide) {
        this.foalAtSide = foalAtSide;
    }

    public boolean isAtStud() {
        return atStud;
    }

    public void setAtStud(boolean atStud) {
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

    public boolean isForSale() {
        return forSale;
    }

    public void setForSale(boolean forSale) {
        this.forSale = forSale;
    }

    public boolean isForLease() {
        return forLease;
    }

    public void setForLease(boolean forLease) {
        this.forLease = forLease;
    }

    public Breed getBreed() {
        return breed;
    }

    public void setBreed(Breed breed) {
        this.breed = breed;
    }
}