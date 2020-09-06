package com.example.FFTEquester.model;

import javax.persistence.Entity;

@Entity
public class EventType extends AbstractEntity{
    private String eventType;

    public String getEventType() {
        return eventType;
    }

    public void setEventType(String eventType) {
        this.eventType = eventType;
    }
}
