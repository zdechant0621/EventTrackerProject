package com.skilldistillery.citylist.services;

import java.util.List;

import com.skilldistillery.citylist.entities.City;

public interface CityService {
	
	List<City> getAllCities();
	List<City> getAllShotGlassBoughtCities();
	City getCity(int cityId);
	City create(City city);
	City update(int cityId, City city);
	boolean deleteById(int cityId);

}
