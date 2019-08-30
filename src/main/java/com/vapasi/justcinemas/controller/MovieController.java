package com.vapasi.justcinemas.controller;

import com.vapasi.justcinemas.model.domain.Location;
import com.vapasi.justcinemas.model.domain.Movie;
import com.vapasi.justcinemas.service.LocationService;
import com.vapasi.justcinemas.service.MovieDetailsService;
import com.vapasi.justcinemas.service.UserValidationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class  MovieController {

    List<Movie> moviesList;
    List<Location> locationList;
    @Autowired
    UserValidationService service;

    @Autowired
    MovieDetailsService movieDetailsService;

    @Autowired
    LocationService locationService;

    @GetMapping("/")
    public String getHome(Model model){
        moviesList = movieDetailsService.getMovieDetails();
        locationList = locationService.getLocation();
        model.addAttribute("movies", moviesList);
        model.addAttribute("locations",locationList);
        return "movie";
    }
}
