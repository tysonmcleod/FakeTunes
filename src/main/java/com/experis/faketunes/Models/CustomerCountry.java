package com.experis.faketunes.Models;

public class CustomerCountry {

    private String country;
    private String count;

    // constructor
    public CustomerCountry(String country, String count){
        this.country = country;
        this.count = count;
    }

    // getters and setters

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCount() {
        return count;
    }

    public void setCount(String count) {
        this.count = count;
    }
}
