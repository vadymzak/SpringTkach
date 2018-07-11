package ua.example.events;

import ua.example.beans.Event;

import java.util.ArrayList;
import java.util.List;

public class CashFileLogger extends FileEventLogger {

    private  int cashSize;

    private List<Event> cache;

    public CashFileLogger(String filename, int cashSize) {
        super(filename);
        this.cashSize = cashSize;
        this.cache = new ArrayList <Event>(cashSize);
    }

    @Override
    public void logEvent(Event event) {
        cache.add(event);

        if (cache.size() == cashSize) {
            writeToFileFromCashe();
            cache.clear();
        }
    }

    private void writeToFileFromCashe() {
        for (Event event : cache
             ) {
            super.logEvent(event);
        }
    }

    public void destroy() {
        if (!cache.isEmpty()) {
            writeToFileFromCashe();
        }
    }
}
