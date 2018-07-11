package ua.example;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import ua.example.beans.Client;
import ua.example.beans.Event;
import ua.example.beans.EventType;
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

        Event event = (Event)ctx.getBean("event");

        app.logEvent(EventType.INFO, event,"Some event for user 1");

        event = (Event)ctx.getBean("event");

        app.logEvent(EventType.ERROR, event,"Some event for user 2");

        event = (Event)ctx.getBean(Event.class);

        app.logEvent(null, event, "Some event for user 3");

        ctx.close();
    }

    private void logEvent(EventType eventType, Event event, String msg) {

        String message = msg.replace(client.getId(), client.getFullName());

        event.setMsg(message);
        try {
            eventLogger.logEvent(event);
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
