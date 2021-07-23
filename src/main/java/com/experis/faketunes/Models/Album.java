package com.experis.faketunes.Models;

public class Album {
    private int albumId;
    private String name;
    private int artistId;

    public Album (int albumId, String name, int artistId) {
        this.albumId = albumId;
        this.name = name;
        this.artistId = artistId;
    }

    public int getAlbumId() {
        return albumId;
    }
    public void setAlbumId(int albumId) {
        this.albumId = albumId;
    }
    public String getName() {
        return name;
    }
    public void setName (String name) {
        this.name = name;
    }
    public int getArtistId() {
        return artistId;
    }
    public void setArtistId(int artistId) {
        this.artistId = artistId;
    }
}
