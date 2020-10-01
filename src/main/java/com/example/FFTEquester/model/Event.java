package com.example.FFTEquester.model;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.text.SimpleDateFormat;
import java.util.Date;


@Entity
public class Event extends AbstractEntity {
    @NotBlank
    @Size(max = 255)
    private String textEntry;
//TODO: add a warning about text entry length
    @ManyToOne
    private Equine equine;

    private String eventTitle;

    @ManyToOne
    private EventType eventType;

    @Basic
    @Temporal(TemporalType.TIMESTAMP)
    private Date timeStamp;

    public String getFormattedDate() {
        String s = new SimpleDateFormat("M/d/yyyy h:mma ").format(timeStamp);
        return s;
    }


    @ManyToOne
    private User user;


    public Event() {
    }

    public Event(@NotBlank @Size(max = 255) String textEntry,
                 Equine equine,
                 String eventTitle,
                 EventType eventType,
                 Date timeStamp,
                 User user) {
        this.textEntry = textEntry;
        this.equine = equine;
        this.eventTitle = eventTitle;
        this.eventType = eventType;
        this.timeStamp = timeStamp;
        this.user = user;
    }

    public String getTextEntry() {
        return textEntry;
    }

    public void setTextEntry(String textEntry) {
        this.textEntry = textEntry;
    }

    public Equine getEquine() {
        return equine;
    }

    public void setEquine(Equine equine) {
        this.equine = equine;
    }

    public String getEventTitle() {
        return eventTitle;
    }

    public void setEventTitle(String eventTitle) {
        this.eventTitle = eventTitle;
    }

    public EventType getEventType() {
        return eventType;
    }

    public void setEventType(EventType eventType) {
        this.eventType = eventType;
    }

    public Date getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(Date timeStamp) {
        this.timeStamp = timeStamp;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}