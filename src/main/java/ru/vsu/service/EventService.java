package ru.vsu.service;

import ru.vsu.dao.EventStorage;
import ru.vsu.dao.Storage;
import ru.vsu.domain.Event;
import ru.vsu.domain.Type;

import java.util.List;

public class EventService {

    private Storage<Event> storage;
    private EventStorage eventStorage = EventStorage.getInstance();

    public EventService(Storage<Event> storage) {
        this.storage = storage;
    }

    public void addAnyEvent(Event event) {
        if (event.getType().equals(Type.BIRTHDAY) || event.getType().equals(Type.MEETING)) {
            eventStorage.addEvent(event);
        }
    }

    public List<Event> getAll() {
        return eventStorage.getAll();
    }

    public List<Event> showOnlyBirthday() {
        return eventStorage.getBirthday();
    }

    public List<Event> showOnlyMeeting() {
        return eventStorage.getMeeting();
    }

    public Event getTargetEvent(int index) {
       return eventStorage.getEvent(index);
    }

    public void deleteTargetEvent(Event targetEvent) {
        eventStorage.deleteEvent(targetEvent);
    }
}
