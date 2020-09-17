package com.example.FFTEquester.model;

import javax.persistence.Entity;

@Entity
public class EventType extends AbstractEntity{
    private String eventType;



    public EventType(String eventType) {
        this.eventType = eventType;
    }

    public EventType() {
    }

    public String getEventType() {
        return eventType;
    }

    public void setEventType(String eventType) {
        this.eventType = eventType;
    }
}
