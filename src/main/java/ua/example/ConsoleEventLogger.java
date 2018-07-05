package ua.example;

import ua.example.interfaces.EventLogger;

public class ConsoleEventLogger implements EventLogger {


    public void logEvent(String msg) {
        System.out.println(msg);
    }
}
