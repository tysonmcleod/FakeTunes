package com.experis.faketunes.Controllers.api;

import com.experis.faketunes.Data_access.ArtistRepository;
import com.experis.faketunes.Models.Artist;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.ArrayList;

public class ArtistController {
    ArtistRepository artistRepository = new ArtistRepository();

    @RequestMapping(value = "/api/artist", method = RequestMethod.GET)
    public ArrayList<Artist> getAllArtist () {
        return artistRepository.getAllAlbum();
    }
}
