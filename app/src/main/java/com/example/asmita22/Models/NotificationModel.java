package com.example.asmita22.Models;

public class NotificationModel {
    String date,event,info;
    public NotificationModel(String Date, String Event,String Info) {
        this.date = Date;
        this.event = Event;
        this.info=Info;
    }

    public String getDate() {
        return date;
    }

    public String getEvent() {
        return event;
    }

    public String getInfo() {
        return info;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public void setEvent(String event) {
        this.event = event;
    }

    public void setInfo(String info) {
        this.info = info;
    }
}
