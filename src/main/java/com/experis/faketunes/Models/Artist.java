package com.experis.faketunes.Models;

public class Artist {
    private String name;
    private int artistId;

    public Artist () {

    }
    public Artist (String name, int artistId) {
        this.artistId = artistId;
        this.name = name;
    }

    public int getArtistId() {
        return artistId;
    }
    public void setArtistId(int artistId) {
        this.artistId = artistId;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
}
