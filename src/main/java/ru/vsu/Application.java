package ru.vsu;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import ru.vsu.config.EventSpringConfig;
import ru.vsu.view.MainView;

public class Application {

    public void run() {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(
                EventSpringConfig.class
        );

        MainView mainView = context.getBean("mainView", MainView.class);

        mainView.show();

        context.close();
    }
}
