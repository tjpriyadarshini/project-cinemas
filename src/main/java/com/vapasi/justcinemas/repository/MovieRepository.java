package com.vapasi.justcinemas.repository;

import com.vapasi.justcinemas.model.domain.Movie;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MovieRepository extends JpaRepository<Movie, Integer> {

}
