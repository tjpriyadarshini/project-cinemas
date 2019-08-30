package com.vapasi.justcinemas.service;

import com.vapasi.justcinemas.model.domain.Movie;
import com.vapasi.justcinemas.repository.MovieRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.Comparator;

import static junit.framework.TestCase.*;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class MovieDetailsServiceTest {
    @Mock
    MovieRepository movieRepository;

    @InjectMocks
    MovieDetailsService movieDetailsService;

    @Test
    public void testGetMovieDetailsReturnsSortedMovieList()
    {
        List<Movie> movieList = new ArrayList<>();
        createMovieList(movieList);
        List<Movie> sortedList = new ArrayList<>(movieList);
        sortedList.sort(Comparator.comparing(Movie::getMovieName));
        when(movieRepository.findAll()).thenReturn(movieList);
        assertEquals(sortedList, movieDetailsService.getMovieDetails());
    }

    private void createMovieList(List<Movie> movieList) {
        Movie movie1 = new Movie();
        movie1.setMovieName("Kabali");
        movie1.setSoundTrack("Dolby Digital");
        movieList.add(movie1);
        Movie movie2 = new Movie();
        movie2.setMovieName("Kennedy Clud");
        movie2.setSoundTrack("Sony Dynamic Digital");
        movieList.add(movie2);
        Movie movie3 = new Movie();
        movie3.setMovieName("Alladin");
        movie3.setSoundTrack("Sony Dynamic Digital");
        movieList.add(movie3);
    }
}
