package com.experis.faketunes.Controllers;

import com.experis.faketunes.Data_access.ArtistRepository;
import com.experis.faketunes.Data_access.GenreRepository;
import com.experis.faketunes.Data_access.SearchRepository;
import com.experis.faketunes.Data_access.TrackRepository;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ViewController {
    ArtistRepository artistRepository = new ArtistRepository();
    TrackRepository trackRepository = new TrackRepository();
    GenreRepository genreRepository = new GenreRepository();
    /*
        Index page
     */
    @RequestMapping(value = "/", method= RequestMethod.GET)
    public String index(Model model) {
        model.addAttribute("artists", artistRepository.getRandomArtists(5));
        model.addAttribute("tracks", trackRepository.getRandomTracks(5));
        model.addAttribute("genres", genreRepository.getRandomGenres(5));
        return "index";
    }

    SearchRepository searchRepository = new SearchRepository();

    @RequestMapping(value = "search", method= RequestMethod.GET)
    public String searchTrack(Model model, @RequestParam(value = "searchString") String searchString) {
        model.addAttribute("searchResult", searchRepository.search(searchString));
        return "search";
    }

}