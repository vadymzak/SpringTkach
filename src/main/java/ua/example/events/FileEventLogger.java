package ua.example.events;

import org.apache.commons.io.FileUtils;
import ua.example.interfaces.EventLogger;

import java.io.File;
import java.io.IOException;

public class FileEventLogger implements EventLogger {

    private String filename;

    private File file;

    public FileEventLogger(String filename) {
        this.filename = filename;
    }

    public void logEvent(Event event) {

        try {
            FileUtils.writeStringToFile(file, event.toString(), true);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void init(){

        file = new File(filename);
        if(file.exists() && !file.canWrite()){
            throw new IllegalArgumentException("Can't write to file - " + filename);
        } else if (!file.exists()) {
            try {
                file.createNewFile();
            } catch (Exception e) {
                throw new IllegalArgumentException("Can't write to file - " + e);
            }
        }

    }
}
