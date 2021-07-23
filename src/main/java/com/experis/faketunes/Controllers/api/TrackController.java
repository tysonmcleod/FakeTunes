package com.experis.faketunes.Controllers.api;

import com.experis.faketunes.Data_access.TrackRepository;
import com.experis.faketunes.Models.Track;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.ArrayList;

public class TrackController {

    TrackRepository trackRepository = new TrackRepository();

    @RequestMapping (value = "/api/track", method = RequestMethod.GET)
    public ArrayList<Track>getAllTrack() {return trackRepository.getAllTrack();}
}
