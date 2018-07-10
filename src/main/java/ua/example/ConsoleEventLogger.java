package ua.example;

import ua.example.events.Event;
import ua.example.interfaces.EventLogger;

public class ConsoleEventLogger implements EventLogger {



    @Override
    public void logEvent(Event event) {
        System.out.println(event);
    }
}
