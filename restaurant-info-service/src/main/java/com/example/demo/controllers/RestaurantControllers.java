package com.example.demo.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.demo.entity.Restaurant;
import com.example.demo.services.RestaurantService;

@RestController
@CrossOrigin(origins="*")
public class RestaurantControllers {
	
	@Autowired
	private RestaurantService service;
	
	@GetMapping(path = "/restaurants")
	public List<Restaurant> findAll(){
		return this.service.findAll();
	}
	
	@GetMapping(path = "/restaurants/{id}")
	public Restaurant findById(@PathVariable("id") int id){
		return this.service.findById(id);
	}
	
	@DeleteMapping(path = "/restaurants/{id}")
	public ResponseEntity<Restaurant> deleteById(@PathVariable("id") int id){
		Restaurant delEntity = this.service.deleteById(id);
		return ResponseEntity.status(HttpStatus.ACCEPTED).body(delEntity);
		
		
	}
	
	@PostMapping(path = "/restaurants")
	public ResponseEntity<Restaurant> add(@RequestBody Restaurant entity){
		
		Restaurant addedEntity = this.service.add(entity);
		return ResponseEntity.status(HttpStatus.CREATED).body(addedEntity);
	}
	
}
