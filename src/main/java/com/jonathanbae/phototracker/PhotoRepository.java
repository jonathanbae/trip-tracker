package com.jonathanbae.triptracker.repository;

import org.springframework.data.repository.CrudRepository;

import com.jonathanbae.phototracker.Photo;

public interface PhotoRepository extends CrudRepository<Photo, Integer> {
    Photo findPhotoByName(String name);
}
