package com.experis.faketunes.Models;

public class CustomerGenre {
    private String firstName;
    private String genreName;
    private String mostTracks;

    // constructor
    public CustomerGenre(String firstName, String genreName, String mostTracks) {
        this.firstName = firstName;
        this.genreName = genreName;
        this.mostTracks = mostTracks;
    }

    public CustomerGenre(String name) {
    }

    // getters and setters


    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getGenreName() {
        return genreName;
    }

    public void setGenreName(String genreName) {
        this.genreName = genreName;
    }

    public String getMostTracks() {
        return mostTracks;
    }

    public void setMostTracks(String mostTracks) {
        this.mostTracks = mostTracks;
    }
}
