package com.vapasi.justcinemas.service;

import com.vapasi.justcinemas.model.domain.Movie;
import com.vapasi.justcinemas.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class MovieDetailsService {

    @Autowired
    MovieRepository movieRepository;

    public List<Movie> getMovieDetails(){
        List<Movie> movieList = movieRepository.findAll();
        movieList.sort(Comparator.comparing(Movie::getMovieName));
        return movieList;
    }
}
