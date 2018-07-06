package ua.example;

import java.util.Date;
import java.util.Random;

public class Event {

    private int id = getRandomId();

    private String msg;

    private Date date;

    public Event(Date date) {
        this.date = date;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "Event{" +
                "id=" + id +
                ", msg='" + msg + '\'' +
                ", date=" + date +
                '}';
    }

    int getRandomId(){
        Random r = new Random();
        return r.nextInt();
    }
}