package ua.example.events;

import ua.example.beans.Event;
import ua.example.interfaces.EventLogger;

public class ConsoleEventLogger implements EventLogger {



    @Override
    public void logEvent(Event event) {
        System.out.println(event);
    }
}
