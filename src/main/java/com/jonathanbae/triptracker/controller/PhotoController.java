//create a controller with CRUD operations for: 
//photos table with fields: 
//    id (auto gen/increment)
//	url
//	description
//	location
//	
//	
//	
//create new, get all, get by id, put (update by id), delete by id

package com.jonathanbae.triptracker.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jonathanbae.triptracker.model.Photo;
import com.jonathanbae.triptracker.repository.PhotoRepository;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping(path = "/photos/")
public class PhotoController {
	private final PhotoRepository photoRepository;

	@Autowired
	public PhotoController(PhotoRepository photoRepository) {
		this.photoRepository = photoRepository;
	}

	@PostMapping()
	public @ResponseBody void addNewPhoto(@RequestBody Photo photo) {
		Photo pic = new Photo(photo);
		photoRepository.save(pic);
	}

	@PostMapping(path = "multi")
	public @ResponseBody void addNewPhotos(@RequestBody List<Photo> photolist) {
		for (int i = 0; i < photolist.size(); i++) {
			photoRepository.save(photolist.get(i));
		}

	}

	@GetMapping()
	public @ResponseBody Iterable<Photo> getAllPhotos() {
		return photoRepository.findAll();
	}

	@GetMapping(path = "{id}")
	public @ResponseBody Optional<Photo> getPhotoByID(@PathVariable Integer id, @RequestBody Photo photo) {
		Photo p = new Photo(photo);
		return photoRepository.findById(p.getID());
	}

	@PutMapping(path = "{id}")
	public @ResponseBody void updatePhotoByID(@PathVariable Integer id, @RequestBody Photo photo) {
		photo.setID(id);
		photoRepository.save(photo);
	}

	@PutMapping(path = "{id}")
	public @ResponseBody void deletePhotoByID(@PathVariable Integer id, @RequestBody Photo photo) {
		photo.setID(id);
		photoRepository.deleteById(id);

	}

}
