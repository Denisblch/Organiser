package ru.vsu.dao;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import ru.vsu.domain.Event;
import ru.vsu.domain.Birthday;
import ru.vsu.domain.Meeting;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Component
public class EventDBStorage implements Storage<Event> {
    private final Connection connection;

    public EventDBStorage(@Value("${eventDBStorage.url}") String url,
                          @Value("${eventDBStorage.user}") String user,
                          @Value("${eventDBStorage.password}") String password) throws SQLException {
        connection = DriverManager.getConnection(url, user, password);
    }

    @Override
    public Event getEvent(int index) {
        try {
            PreparedStatement ps = connection.prepareStatement(
                    "SELECT * FROM event WHERE id_event = ?");
            ps.setInt(1, index);
            ResultSet rs = ps.executeQuery();
            rs.first();
            String date = rs.getString(3);
            String hour = rs.getString(4);
            String gift = rs.getString(5);
            String description = rs.getString(6);
            if (rs.getString(2).equals("День рождения")) {
                return new Birthday(date, hour, gift, description);
            } else if (rs.getString(2).equals("Встреча")) {
                return new Meeting(date, hour, gift, description);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void addEvent(Event event) {
        switch (event.getType()) {
            case BIRTHDAY:
                Birthday birthday = (Birthday) event;
                String nameBirthday = birthday.getName();
                String dateBirthday = birthday.getDate();
                String hour = birthday.getHourOfBirth();
                String gift = birthday.getGift();
                String descriptionBirthday = birthday.getDescription();
                addEventIntoTable(nameBirthday, dateBirthday, hour, gift, descriptionBirthday);
                break;
            case MEETING:
                Meeting meeting = (Meeting) event;
                String nameMeeting = meeting.getName();
                String dateMeeting = meeting.getDate();
                String interlocutor = meeting.getNameOfInterlocutor();
                String startTime = meeting.getStartTime();
                String descriptionMeeting = meeting.getDescription();
                addEventIntoTable(nameMeeting, dateMeeting, interlocutor, startTime, descriptionMeeting);
                break;
        }
    }

    @Override
    public void deleteEvent(int index) {
        try {
            PreparedStatement ps = connection.prepareStatement("DELETE FROM event WHERE id_event = ?");
            ps.setInt(1, index);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void editEvent(Event event) {
        try {
            PreparedStatement ps = connection.prepareStatement("UPDATE event SET date = ?, gift_time = ? WHERE id_event = ?");
            ps.setString(1, "new date");
            ps.setString(2, "new time");
            ps.setInt(3, event.getId());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Event> getAll() {
        try {
            PreparedStatement ps = connection.prepareStatement("SELECT * FROM event");
            return getListEvents(ps);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    private void addEventIntoTable(String name, String date, String hourInterlocutor, String giftTime, String description) {
        try {
            PreparedStatement ps = connection.prepareStatement(
                    "INSERT INTO event VALUES (null, ?, ?, ?, ?, ?)");
            ps.setString(1, name);
            ps.setString(2, date);
            ps.setString(3, hourInterlocutor);
            ps.setString(4, giftTime);
            ps.setString(5, description);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private List<Event> getListEvents(PreparedStatement ps) throws SQLException {
        ResultSet rs = ps.executeQuery();
        int size = getSize(rs);
        List<Event> events = new ArrayList<>();
        for (int i = 1; i <= size; i++) {
            events.add(getEvent(i));
        }
        return events;
    }

    private static int getSize(ResultSet rs) {
        int size;
        try {
            rs.last();
            size = rs.getRow();
            rs.beforeFirst();
        } catch (SQLException ex) {
            return 0;
        }
        return size;
    }
}
