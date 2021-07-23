package com.experis.faketunes.Controllers.api;

import com.experis.faketunes.Data_access.TrackRepository;
import com.experis.faketunes.Models.Track;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.ArrayList;

public class TrackController {

    TrackRepository trackRepository = new TrackRepository();

    @RequestMapping (value = "/api/track", method = RequestMethod.GET)
    public ArrayList<Track>getAllTrack() {return trackRepository.getAllTrack();}

    @RequestMapping(value= "/api/track/{name}", method = RequestMethod.GET)
    public Track getSpecificTrack(@PathVariable String name){
        return trackRepository.getSpecificTrack(name);
    }
}

