package com.skilldistillery.citylist.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.skilldistillery.citylist.entities.City;
import com.skilldistillery.citylist.repositories.CityRepository;

@Service
public class CityServiceImpl implements CityService {

	@Autowired
	private CityRepository cityRepo;

	@Override
	public List<City> getAllCities() {
		return cityRepo.findAll();
	}

	@Override
	public City getCity(int cityId) {
		return cityRepo.findById(cityId);
	}

	@Override
	public List<City> getAllShotGlassBoughtCities() {
		return cityRepo.findByShotGlassBoughtTrue();
	}

	@Override
	public City create(City city) {
		return cityRepo.save(city);
	}

	@Override
	public City update(int cityId, City city) {
		City existingCity = cityRepo.findById(cityId);
		existingCity.setCity(city.getCity());
		existingCity.setStateCountry(city.getStateCountry());
		existingCity.setDescription(city.getDescription());
		existingCity.setArrivalDate(city.getArrivalDate());
		existingCity.setDepartureDate(city.getDepartureDate());
		existingCity.setShotGlassBought(city.isShotGlassBought());
		cityRepo.save(existingCity);
		return existingCity;
	}

	@Override
	public boolean deleteById(int cityId) {
		boolean isDeleted = false;
		City deactivate = cityRepo.findById(cityId);
		
		if(deactivate != null) {
			deactivate.setEnabled(false);
			cityRepo.save(deactivate);
			if(!cityRepo.findById(cityId).isEnabled()) {
				isDeleted = true;
			}
		}
		
		return isDeleted;
	}
}
