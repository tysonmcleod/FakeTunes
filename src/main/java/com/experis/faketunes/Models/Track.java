package com.experis.faketunes.Models;

public class Track {
    private int trackID;
    private String name;
    //private int artistID;

    public  Track () {

    }
    public Track (int trackID, String name) {
        this.trackID = trackID;
        this.name = name;
    }

    public int getTrackID() {
        return trackID;
    }
    public void setTrackID(int trackID) {
        this.trackID = trackID;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
}
