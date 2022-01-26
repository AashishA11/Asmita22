package com.example.asmita22.Models;

public class SponsorsModel {
    int img;
    String SponsorName;

    public SponsorsModel(int img, String sponsorName) {
        this.img = img;
        SponsorName = sponsorName;
    }

    public int getImg() {
        return img;
    }

    public void setImg(int img) {
        this.img = img;
    }

    public String getSponsorName() {
        return SponsorName;
    }

    public void setSponsorName(String sponsorName) {
        SponsorName = sponsorName;
    }
}
