package com.jonathanbae.triptracker.repository;

import com.jonathanbae.triptracker.model.Trip;
import org.springframework.data.repository.CrudRepository;

public interface TripRepository extends CrudRepository<Trip, Integer> {
    Trip findTripByName(String name);
}
