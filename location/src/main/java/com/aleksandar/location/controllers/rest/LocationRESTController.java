package com.aleksandar.location.controllers.rest;

import com.aleksandar.location.entities.Location;
import com.aleksandar.location.repositories.LocationRepository;
import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.swing.plaf.PanelUI;
import java.util.List;

@RestController
@RequestMapping("/locations")
public class LocationRESTController {

    @Autowired
    LocationRepository locationRepository;

    @GetMapping
    public List<Location> getLocations(){
        return locationRepository.findAll();
    }

    @PostMapping
    public Location createLocation(@RequestBody Location location){
        return locationRepository.save(location);
    }

    @PutMapping
    public Location updateLocation(@RequestBody Location location){
        return locationRepository.save(location);
    }

    @DeleteMapping("/{id}")
    public void deleteLocation(@PathVariable("id") int id){
        locationRepository.deleteById(id);
    }

    @GetMapping("/{id}")
    @JsonIgnore
    public Location getLocation(@PathVariable("id") int id){
        return locationRepository.getOne(id);
    }
}
