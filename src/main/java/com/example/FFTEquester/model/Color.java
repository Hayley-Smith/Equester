package com.example.FFTEquester.model;


import javax.persistence.Entity;

@Entity
public class Color extends AbstractEntity{
    private String color;


    public Color() {
    }

    public Color(String color) {
        this.color = color;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
}
