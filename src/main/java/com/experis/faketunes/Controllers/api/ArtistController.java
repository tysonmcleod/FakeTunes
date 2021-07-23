package com.experis.faketunes.Controllers.api;

import com.experis.faketunes.Data_access.ArtistRepository;
import com.experis.faketunes.Models.Artist;
import com.experis.faketunes.Models.Customer;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.ArrayList;

public class ArtistController {
    ArtistRepository artistRepository = new ArtistRepository();

    @RequestMapping(value = "/api/artist", method = RequestMethod.GET)
    public ArrayList<Artist> getAllArtist () {
        return artistRepository.getAllArtist();
    }
    @RequestMapping(value="/api/artist/add", method = RequestMethod.POST)
    public Boolean addArtist(@RequestBody Artist artist){
        return artistRepository.addArtist(artist);
    }
}
