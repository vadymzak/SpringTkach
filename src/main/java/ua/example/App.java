package ua.example;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import ua.example.interfaces.EventLogger;

public class App {

    private Client client;

    private EventLogger eventLogger;

    App() { }

    App(Client client, EventLogger eventLogger) {
        this.client = client;
        this.eventLogger = eventLogger;
    }

    public static void main(String[] args) {

        ApplicationContext ctx = new ClassPathXmlApplicationContext("spring.xml");

        App app = (App)ctx.getBean("app");

        app.client = new Client("1", "John Smith");

        app.logEvent(ctx, "Some event for user 1");
    }

    private void logEvent(ApplicationContext ctx, String msg) {

        String message = msg.replace(client.getId(), client.getFullName());
        Event event = (Event)ctx.getBean("event");
        event.setMsg(message);
        eventLogger.logEvent(event);


    }
}
