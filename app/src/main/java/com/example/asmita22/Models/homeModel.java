package com.example.asmita22.Models;

public class homeModel {
     int img;
     String EventName;

    public homeModel(int img, String eventName) {
        this.img = img;
        EventName = eventName;
    }

    public int getImg() {
        return img;
    }

    public void setImg(int img) {
        this.img = img;
    }

    public String getEventName() {
        return EventName;
    }

    public void setEventName(String eventName) {
        EventName = eventName;
    }
}
