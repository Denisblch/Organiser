package ru.vsu;

import ru.vsu.dao.EventStorage;
import ru.vsu.dao.Storage;
import ru.vsu.domain.Event;
import ru.vsu.service.EventService;
import ru.vsu.view.MainView;

public class Application {

    public void run() {
        Storage<Event> storage = EventStorage.getInstance();
        EventService eventService = new EventService(storage);
        MainView mainView = new MainView(eventService);
        mainView.show();
    }
}
