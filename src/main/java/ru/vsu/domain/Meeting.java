package ru.vsu.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import static ru.vsu.domain.Type.MEETING;

@Entity
@Table(name = "meeting")
public class Meeting extends Event {
    @Column(name = "date")
    private String date;
    @Column(name = "name_of_interlocutor")
    private String nameOfInterlocutor;
    @Column(name = "start_time")
    private String startTime;
    @Column(name = "description")
    private String description;

    public Meeting(String date, String nameOfInterlocutor, String startTime, String description) {
        super(MEETING, "Встреча");
        this.date = date;
        this.nameOfInterlocutor = nameOfInterlocutor;
        this.startTime = startTime;
        this.description = description;
    }

    public Meeting() {

    }

    public String getDate() {
        return date;
    }

    public String getNameOfInterlocutor() {
        return nameOfInterlocutor;
    }

    public String getStartTime() {
        return startTime;
    }

    public String getDescription() {
        return description;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public void setNameOfInterlocutor(String nameOfInterlocutor) {
        this.nameOfInterlocutor = nameOfInterlocutor;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Meeting: " +
                "date = " + date +
                ", nameOfInterlocutor = " + nameOfInterlocutor +
                ", startTime = " + startTime +
                ", description = " + description;
    }
}
