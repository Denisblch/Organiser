package ru.vsu;

import ru.vsu.dao.EventDBStorage;
import ru.vsu.service.EventService;
import ru.vsu.view.MainView;

import java.sql.SQLException;

public class Application {

    public void run() throws SQLException {
        EventService eventService = new EventService(new EventDBStorage());
        MainView mainView = new MainView(eventService);
        mainView.show();
    }
}
