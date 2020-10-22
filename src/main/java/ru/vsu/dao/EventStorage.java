package ru.vsu.dao;

import ru.vsu.domain.Event;
import ru.vsu.domain.Type;
import ru.vsu.events.Birthday;
import ru.vsu.events.Meeting;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class EventStorage implements Storage<Event> {

    private static EventStorage instance;

    private List<Event> events = new ArrayList<>();
    private List<Event> targetEvents = new ArrayList<>();

    private EventStorage() {
        init();
    }

    public static EventStorage getInstance() {
        if (instance == null) {
            instance = new EventStorage();
        }
        return instance;
    }

    @Override
    public Event getEvent(int index) {
        return events.get(index);
    }


    @Override
    public void addEvent(Event event) {
        events.add(event);
    }

    @Override
    public List<Event> getAll() {
        return events;
    }

    private void init() {
        try {
            Date date = new SimpleDateFormat("dd.MM.yyyy").parse("28.12.2016");
            Birthday birthday = new Birthday(date, "19:00", "BMW","Описание...");
            Meeting meeting = new Meeting(date, "Василий","13:25","Описание...");
            events.add(birthday);
            events.add(meeting);
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    public List<Event> getBirthday() {
        for (Event event : events) {
            if (event.getType().equals(Type.BIRTHDAY)) {
                targetEvents.add(event);
            }
        }
        return targetEvents;
    }

    public List<Event> getMeeting() {
        for (Event event : events) {
            if (event.getType().equals(Type.MEETING)) {
                targetEvents.add(event);
            }
        }
        return targetEvents;
    }

    @Override
    public void deleteEvent(Event targetEvent) {
        events.remove(targetEvent);
    }
}
