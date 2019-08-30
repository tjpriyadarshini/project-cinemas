package com.vapasi.justcinemas.service;

import com.vapasi.justcinemas.model.domain.Location;
import com.vapasi.justcinemas.repository.LocationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LocationService {
    @Autowired
    LocationRepository locationRepository;
  public List<Location> getLocation(){
      List<Location> locationList = locationRepository.findAll();
      return locationList;
  }
}
