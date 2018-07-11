package ua.example.events;

import ua.example.beans.Event;
import ua.example.interfaces.EventLogger;
import java.io.IOException;
import java.util.List;

public class CombinedEventLogger implements EventLogger {

    private List<EventLogger> loggers;

    public CombinedEventLogger(List <EventLogger> loggers) {
        this.loggers = loggers;
    }

    @Override
    public void logEvent(Event event) throws IOException {

        for (EventLogger loger : loggers
             ) {
            loger.logEvent(event);
        }
    }
}
