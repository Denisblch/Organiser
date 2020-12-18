package ru.vsu.dao;

import ru.vsu.domain.Event;
import ru.vsu.domain.Type;
import ru.vsu.events.Birthday;
import ru.vsu.events.Meeting;

import java.util.ArrayList;
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
        Birthday birthday = new Birthday("28.12.2016", "19:00", "BMW","Описание...");
        Meeting meeting = new Meeting("28.12.2016", "Василий","13:25","Описание...");
        events.add(birthday);
        events.add(meeting);
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
    public void deleteEvent(int index) {
        events.remove(index);
    }

    @Override
    public void editEvent(int index, String var2, String var3) {

    }
}
