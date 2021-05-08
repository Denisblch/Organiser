package ru.vsu.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import static ru.vsu.domain.Type.BIRTHDAY;

@Entity
@Table(name = "birthday")
public class Birthday extends Event {
    @Column(name = "date")
    private String date;
    @Column(name = "hour_of_birth")
    private String hourOfBirth;
    @Column(name = "gift")
    private String gift;
    @Column(name = "description")
    private String description;

    public Birthday(String date, String hourOfBirth, String gift, String description) {
        super(BIRTHDAY, "День рождения");
        this.date = date;
        this.hourOfBirth = hourOfBirth;
        this.gift = gift;
        this.description = description;
    }

    public Birthday() {

    }

    public String getDate() {
        return date;
    }

    public String getHourOfBirth() {
        return hourOfBirth;
    }

    public String getGift() {
        return gift;
    }

    public String getDescription() {
        return description;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public void setHourOfBirth(String hourOfBirth) {
        this.hourOfBirth = hourOfBirth;
    }

    public void setGift(String gift) {
        this.gift = gift;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Birthday: " +
                "date = " + date +
                ", hourOfBirth = " + hourOfBirth +
                ", gift = " + gift +
                ", description = " + description;
    }
}
