package ru.vsu.events;

import ru.vsu.domain.Event;

import static ru.vsu.domain.Type.BIRTHDAY;

public class Birthday extends Event {
    private String date;
    private String hourOfBirth;
    private String gift;
    private String description;

    public Birthday(String date, String hourOfBirth, String gift, String description) {
        super(BIRTHDAY, "День рождения");
        this.date = date;
        this.hourOfBirth = hourOfBirth;
        this.gift = gift;
        this.description = description;
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
