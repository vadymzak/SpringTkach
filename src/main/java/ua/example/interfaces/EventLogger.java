package ua.example.interfaces;

import ua.example.events.Event;

import java.io.IOException;

public interface EventLogger {

    void logEvent(Event event) throws IOException;
}
