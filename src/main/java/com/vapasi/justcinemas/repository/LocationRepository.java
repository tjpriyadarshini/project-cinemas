package com.vapasi.justcinemas.repository;

import com.vapasi.justcinemas.model.domain.Location;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LocationRepository extends JpaRepository<Location,Integer> {
}
