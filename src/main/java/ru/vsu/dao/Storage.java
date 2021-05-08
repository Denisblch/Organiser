package ru.vsu.dao;

import ru.vsu.domain.Event;

import java.util.List;

public interface Storage<T> {

    Event getEvent(int id);

    void addEvent(Event event);

    void deleteEvent(int id);

    void editEvent(Event event);

    List<T> getAll();
}
