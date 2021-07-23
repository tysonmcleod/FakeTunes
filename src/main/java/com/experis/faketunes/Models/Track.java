package com.experis.faketunes.Models;

public class Track {
    private String trackId;
    private String name;

    public Track(String trackId, String name) {
        this.trackId = trackId;
        this.name = name;
    }

    public String getTrackId() {
        return trackId;
    }

    public void setTrackId(String trackId) {
        this.trackId = trackId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
