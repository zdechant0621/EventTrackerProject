package com.skilldistillery.citylist.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.skilldistillery.citylist.entities.City;

public interface CityRepository extends JpaRepository<City, Integer> {

}
