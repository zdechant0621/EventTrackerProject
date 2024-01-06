package com.skilldistillery.citylist.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.skilldistillery.citylist.entities.City;
import com.skilldistillery.citylist.services.CityService;

@RestController
@RequestMapping("api")
public class CityController {
	
	@Autowired
	private CityService cityService;
	
	@GetMapping("cities")
	public List<City> index() {
		List<City> cities = cityService.getAllCities();
		return cities;
	}

}
