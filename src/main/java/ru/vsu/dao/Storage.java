package ru.vsu.dao;

import ru.vsu.domain.Event;

import java.util.List;

public interface Storage<T> {

    Event getEvent(int index);

    void addEvent(Event event);

    void deleteEvent(int index);

    void editEvent(int index, String var1, String var2);

    List<T> getAll();
}
