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
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public City create(City city) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public City update(int cityId, City city) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean deleteById(int cityId) {
		// TODO Auto-generated method stub
		return false;
	}

}
