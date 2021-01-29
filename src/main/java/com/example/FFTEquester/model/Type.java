package com.example.FFTEquester.model;

import javax.persistence.Entity;

@Entity
public class Type extends AbstractEntity{

    private String type;

    public Type() {
    }

    public Type(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}