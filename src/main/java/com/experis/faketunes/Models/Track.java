package com.experis.faketunes.Models;

public class Track {
    private String trackID;
    private String name;
    //private int artistID;

    public  Track () {

    }
    public Track (String trackID, String name) {
        this.trackID = trackID;
        this.name = name;
    }

    public String getTrackID() {
        return trackID;
    }
    public void setTrackID(String trackID) {
        this.trackID = trackID;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
}
