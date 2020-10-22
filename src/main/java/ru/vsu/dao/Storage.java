package ru.vsu.dao;

import ru.vsu.domain.Event;

import java.util.List;

public interface Storage<T> {

    Event getEvent(int index);

    void addEvent(Event event);

    List<Event> getBirthday();

    List<Event> getMeeting();

    void deleteEvent(Event event);

    List<T> getAll();
}
