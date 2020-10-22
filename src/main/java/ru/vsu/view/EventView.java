package ru.vsu.view;

import ru.vsu.domain.Event;
import ru.vsu.domain.Type;
import ru.vsu.events.Birthday;
import ru.vsu.events.Meeting;
import ru.vsu.service.EventService;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class EventView {

    private int index;
    private EventService eventService;
    private Scanner scanner = new Scanner(System.in);

    public EventView(EventService eventService) {
        this.eventService = eventService;
    }

    public void showAll() {
        System.out.println("All events: ");
        List<Event> eventList = eventService.getAll();
        eventList.forEach(System.out::println);
    }

    public void doAddEvent() throws ParseException {
        System.out.println("Какое событие вы хотите добавить - B/M (Birthday/Meeting)?");
        String str = scanner.nextLine().toUpperCase();
        if (str.equals("B")) {
            System.out.println("Введите дату: ");
            String date = scanner.nextLine();
            Date localDate = new SimpleDateFormat("DD.MM.YYYY").parse(date);
            Birthday birthday = new Birthday(localDate, "19:00", "BMW", "Описание...");
            eventService.addAnyEvent(birthday);
        } else if (str.equals("M")) {
            System.out.println("Введите дату: ");
            String date = scanner.nextLine();
            Date localDate = new SimpleDateFormat("DD.MM.YYYY").parse(date);
            Meeting meeting = new Meeting(localDate, "Василий", "13:25", "Описание...");
            eventService.addAnyEvent(meeting);
        }
    }

    public void doDeleteEvent() {
        System.out.println("Какое событие вы желаете удалить?");
        showAll();
        index = scanner.nextInt();
        Event event = eventService.getTargetEvent(index);
        eventService.deleteTargetEvent(event);
    }

    public void doDetailedViewEvent() {
        System.out.println("Что желаете просмотреть: ");
        showAll();
        index = scanner.nextInt();
        Event event = eventService.getTargetEvent(index);
        if (event.getType().equals(Type.BIRTHDAY)) {
            Birthday birthday = (Birthday) eventService.getTargetEvent(index);
            System.out.println("Name: " + birthday.getName());
            System.out.println("Date:" + birthday.getDate());
            System.out.println("Hour of birth: " + birthday.getHourOfBirth());
            System.out.println("Gift: " + birthday.getGift());
            System.out.println("Description: " + birthday.getDescription());
        } else if (event.getType().equals(Type.MEETING)) {
            Meeting meeting = (Meeting) eventService.getTargetEvent(index);
            System.out.println("Name: " + meeting.getName());
            System.out.println("Date: " + meeting.getDate());
            System.out.println("Name of interlocutor: " + meeting.getNameOfInterlocutor());
            System.out.println("Start time: " + meeting.getStartTime());
            System.out.println("Description: " + meeting.getDescription());
        }
    }

    public void doEditEvent() {
        System.out.println("Что желаете отредактировать - B/M (BIRTHDAY / MEETING)?");
        String str = scanner.nextLine().toUpperCase();
        if (str.equals("B")) {
            List<Event> eventList = eventService.showOnlyBirthday();
            eventList.forEach(System.out::println);
            System.out.println("Выберите определенное событие: ");
            index = scanner.nextInt();
            Birthday birthday = (Birthday) eventService.getTargetEvent(index);
            try {
                birthday.setDate(new SimpleDateFormat("dd.MM.yyyy").parse("20.05.2025"));
            } catch (ParseException e) {
                e.printStackTrace();
            }
            birthday.setGift("Router");
            System.out.println("update successfully");
        } else if (str.equals("M")) {
            List<Event> eventList = eventService.showOnlyMeeting();
            eventList.forEach(System.out::println);
            System.out.println("Выберите определенное событие: ");
            index = scanner.nextInt();
            Meeting meeting = (Meeting) eventService.getTargetEvent(index);
            meeting.setNameOfInterlocutor("Nikolai");
            meeting.setStartTime("21:20");
            System.out.println("update successfully");
        }
    }
}
