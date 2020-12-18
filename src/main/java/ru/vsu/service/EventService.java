package ru.vsu.service;

import ru.vsu.dao.Storage;
import ru.vsu.domain.Event;
import ru.vsu.domain.Type;

import java.util.List;

public class EventService {

    private Storage<Event> storage;

    public EventService(Storage<Event> storage) {
        this.storage = storage;
    }

    public void addAnyEvent(Event event) {
        if (event.getType().equals(Type.BIRTHDAY) || event.getType().equals(Type.MEETING)) {
            storage.addEvent(event);
        }
    }

    public List<Event> getAll() {
        return storage.getAll();
    }



    public Event getTargetEvent(int index) {
       return storage.getEvent(index);
    }

    public void deleteTargetEvent(int index) {
        storage.deleteEvent(index);
    }

    public void editTargetEvent(int index, String date, String time) {
        storage.editEvent(index, date, time);
    }
}
