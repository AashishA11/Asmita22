
package com.example.asmita22.Models;

public class TeamModel {
    String img;
    String Name,position,mail;
    public TeamModel(String img, String name,String position,String mail) {
        this.img = img;
        this.Name = name;
        this.position=position;
        this.mail=mail;
    }

    public String getName() {
        return Name;
    }

    public String getPosition() {
        return position;
    }

    public String getMail() {
        return mail;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public void setName(String Name) {
        this.Name = Name;
    }
}

