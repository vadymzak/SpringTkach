package ua.example;

import ua.example.interfaces.EventLogger;

public class App {

    private Client client;

    private ConsoleEventLogger eventLogger;

    App() { }

    App(Client client, EventLogger eventLogger) {

    }

    public static void main(String[] args) {

        App app = new App();

        app.client = new Client("1", "John Smith");
        app.eventLogger = new ConsoleEventLogger();

        app.logEvent("Some event for user 1");
    }

    private void logEvent(String msg) {

        String message = msg.replace(client.getId(), client.getFullName());

        eventLogger.logEvent(message);


    }
}
