package ru.vsu.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import ru.vsu.dao.Storage;
import ru.vsu.domain.Event;
import ru.vsu.domain.Type;

import javax.transaction.Transactional;
import java.util.List;

@Component
public class EventService {

    private final Storage<Event> storage;

    @Autowired
    public EventService(@Qualifier("eventHibernateStorage") Storage<Event> storage) {
        this.storage = storage;
    }

    @Transactional
    public void addAnyEvent(Event event) {
        if (event.getType().equals(Type.BIRTHDAY) || event.getType().equals(Type.MEETING)) {
            storage.addEvent(event);
        }
    }

    @Transactional
    public List<Event> getAll() {
        return storage.getAll();
    }

    @Transactional
    public Event getTargetEvent(int index) {
       return storage.getEvent(index);
    }

    @Transactional
    public void deleteTargetEvent(int index) {
        storage.deleteEvent(index);
    }

    @Transactional
    public void editTargetEvent(Event event) {
        storage.editEvent(event);
    }
}
