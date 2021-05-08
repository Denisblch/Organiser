package ru.vsu.view;

import org.springframework.stereotype.Component;
import ru.vsu.service.EventService;

import java.util.Scanner;

@Component
public class MainView {

    private EventService eventService;

    private Scanner scanner = new Scanner(System.in);

    public MainView(EventService eventService) {
        this.eventService = eventService;
    }

    public void show() {
        while (true) {
            System.out.println("Main menu");
            System.out.println("1 - Show all events");
            System.out.println("2 - Add event");
            System.out.println("3 - Delete event");
            System.out.println("4 - Detailed view event");
            System.out.println("5 - Edit event");
            System.out.println("0 - Exit");

            int commandCode = scanner.nextInt();
            EventView eventView = new EventView(eventService);
            switch (commandCode) {
                case 1:
                    eventView.showAll();
                    break;
                case 2:
                    eventView.doAddEvent();
                    break;
                case 3:
                    eventView.doDeleteEvent();
                    break;
                case 4:
                    eventView.doDetailedViewEvent();
                    break;
                case 5:
                    eventView.doEditEvent();
                    break;
                case 0:
                    return;
            }
        }
    }
}
