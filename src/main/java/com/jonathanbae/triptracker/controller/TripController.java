package com.jonathanbae.triptracker.controller;

import com.jonathanbae.triptracker.model.Trip;
import com.jonathanbae.triptracker.repository.TripRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;

@Controller
@RequestMapping(path = "/trips/")
public class TripController {
    private final TripRepository tripRepository;

    @Autowired
    public TripController(TripRepository tripRepository) {
        this.tripRepository = tripRepository;
    }

    @PostMapping()
    public @ResponseBody
    Integer addNewUser(@RequestBody Trip trip) {
        Trip t = new Trip(trip);
        tripRepository.save(t);
        return t.getId();
    }

    @GetMapping()
    public @ResponseBody
    Iterable<Trip> getAllUsers() {
        // This returns a JSON or XML with the users
        return tripRepository.findAll();
    }

    @GetMapping(path="{id}")
    public @ResponseBody
    Trip getTripByID(@PathVariable Integer id) {
        Integer[] ids = {id};
        Iterable<Integer> i = Arrays.asList(ids);
        return tripRepository.findAllById(i).iterator().next();
    }
    
    @PutMapping(path="{id}")
    public @ResponseBody Trip updateTrip(@PathVariable Integer id, @RequestBody Trip trip) {
        trip.setId(id);
        tripRepository.save(trip);
        return trip;
    }
}
