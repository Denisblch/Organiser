package ru.vsu.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ru.vsu.domain.Birthday;
import ru.vsu.domain.Event;
import ru.vsu.domain.Meeting;

import java.util.ArrayList;
import java.util.List;

@Repository
public class EventHibernateStorage implements Storage<Event> {
    private SessionFactory sessionFactory;

    @Autowired
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public Event getEvent(int id) {
        Session session = sessionFactory.getCurrentSession();
        return session.get(Event.class, id);
    }

//    public Birthday getB(int index) {
//        Session session = sessionFactory.getCurrentSession();
//        return session.get(Birthday.class, index);
//    }

    @Override
    public void addEvent(Event event) {
        Session session = sessionFactory.getCurrentSession();
        session.persist(event);
    }

    @Override
    public void deleteEvent(int index) {
        Session session = sessionFactory.getCurrentSession();
        session.delete(getEvent(index));
    }

    @Override
    public void editEvent(Event event) {
        Session session = sessionFactory.getCurrentSession();
        session.update(event);
    }

//    public List<Birthday> getBirthday() {
//        Session session = sessionFactory.getCurrentSession();
//        return session.createQuery("from Birthday", Birthday.class).list();
//    }
//
//    public List<Meeting> getMeeting() {
//        Session session = sessionFactory.getCurrentSession();
//        return session.createQuery("from Meeting", Meeting.class).list();
//    }

    @Override
    public List<Event> getAll() {
//        List<Event> events = new ArrayList<>();
//        events.addAll(getBirthday());
//        events.addAll(getMeeting());
//        return events;
        Session session = sessionFactory.getCurrentSession();
        return session.createQuery("from Event", Event.class).list();
    }
}
