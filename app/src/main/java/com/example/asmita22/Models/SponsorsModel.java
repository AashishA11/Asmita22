package com.example.asmita22.Models;

public class SponsorsModel {
    String img;
    String SponsorName;

    String Link;
    public SponsorsModel(String img, String sponsorName,String link) {
        this.img=img;
        this.SponsorName=sponsorName;
        this.Link=link;
    }

    public String getImg() {
        return img;
    }

    public String getSponsorName() {
        return SponsorName;
    }

    public String getLink() {
        return Link;
    }
}
