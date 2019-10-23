package com.aad_team_42.travelmanticsrebranded.model;

import java.io.Serializable;

public class Event implements Serializable {
    private String image;
    private String event;
   // private String specs;


    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getEvent() {
        return event;
    }

    public void setEvent(String event) {
        this.event = event;
    }

//    public String getSpecs() {
//        return specs;
//    }
//
//    public void setSpecs(String specs) {
//        this.specs = specs;
//    }
}
