package com.skilldistillery.citylist.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.skilldistillery.citylist.entities.City;
import com.skilldistillery.citylist.services.CityService;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@RestController
@RequestMapping("/api/cities")
public class CityController {
	
	@Autowired
    private CityService cityService;

    @GetMapping
    public List<City> getAllCities() {
        return cityService.getAllCities();
    }

    @GetMapping("/{id}")
	public City getCity(@PathVariable("id") int id, HttpServletResponse res) {
		City city = cityService.getCity(id);

		if (city != null && city.isEnabled() == true) {
			res.setStatus(200);
		} else {
			res.setStatus(404);
			city = null;
		}
		return city;
	}

    @GetMapping("/shotglassbought")
    public List<City> getAllShotGlassBoughtCities() {
        return cityService.getAllShotGlassBoughtCities();
    }

    @PostMapping
	public City addCity(@RequestBody City city, HttpServletResponse res,
			HttpServletRequest req
			) {
		City newCity = null;
		try {
			newCity = cityService.create(city);
			if(newCity == null) {
				throw new Exception();
			}
			res.setStatus(201);
			res.setHeader("City", req.getRequestURL().append("/").append(newCity.getId()).toString());
		} catch (Exception e) {
			e.printStackTrace();
			res.setStatus(400);
		}
		return newCity;
	}

    @PutMapping("/{id}")
	public City updateCity(@PathVariable("id") int id, @RequestBody City city, HttpServletResponse res,
			HttpServletRequest req
			) {
		City updateCity = null;
		if (cityService.getCity(id)!=null) {
			try {
				updateCity = cityService.update(id, city);
				res.setStatus(200);
				res.setHeader("City", req.getRequestURL().append("/").append(updateCity.getId()).toString());
			} catch (Exception e) {
				e.printStackTrace();
				res.setStatus(400);
			}
		} else {
			res.setStatus(404);
		}

		return updateCity;

	}

	@DeleteMapping("/{id}")
	public boolean deleteCity(@PathVariable("id") int id, HttpServletResponse res) {
		boolean deleted = false;
		if(cityService.getCity(id)!=null) {
			deleted = cityService.deleteById(id);
			res.setStatus(204);
		} else {
			res.setStatus(404);
		}
		return deleted;
	}
}
