package ua.example;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import ua.example.events.Event;
import ua.example.interfaces.EventLogger;

import java.io.IOException;

public class App {

    private Client client;

    private EventLogger eventLogger;

    App() { }

    App(Client client, EventLogger eventLogger) {
        this.client = client;
        this.eventLogger = eventLogger;
    }

    public static void main(String[] args) {

        ConfigurableApplicationContext ctx = new ClassPathXmlApplicationContext("spring.xml");

        App app = (App)ctx.getBean("app");

        app.logEvent(ctx, "Some event for user 1");

        ctx.close();
    }

    private void logEvent(ApplicationContext ctx, String msg) {

        String message = msg.replace(client.getId(), client.getFullName());
        Event event = (Event)ctx.getBean("event");
        event.setMsg(message);
        try {
            eventLogger.logEvent(event);
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
