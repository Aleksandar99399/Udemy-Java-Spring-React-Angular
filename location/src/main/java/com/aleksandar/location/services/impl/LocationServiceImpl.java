package com.aleksandar.location.services.impl;

import com.aleksandar.location.entities.Location;
import com.aleksandar.location.repositories.LocationRepository;
import com.aleksandar.location.services.LocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LocationServiceImpl implements LocationService {

    @Autowired
    private LocationRepository repository;

    public LocationRepository getRepository() {
        return repository;
    }

    public LocationServiceImpl setRepository(LocationRepository repository) {
        this.repository = repository;
        return this;
    }

    @Override
    public Location saveLocation(Location location) {
        return repository.save(location);
    }

    @Override
    public Location updateLocation(Location location) {
        return repository.save(location);
    }

    @Override
    public void deleteLocation(Location location) {
        repository.delete(location);
    }

    @Override
    public Location getLocationById(int id) {
        return repository.findById(id).get();
    }

    @Override
    public List<Location> getAllLocations() {
        return repository.findAll();
    }
}
