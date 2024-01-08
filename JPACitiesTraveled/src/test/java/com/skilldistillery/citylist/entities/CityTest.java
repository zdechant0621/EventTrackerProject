package com.skilldistillery.citylist.entities;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

class CityTest {
	
	private static EntityManagerFactory emf;
	private EntityManager em;
	private City city;
	

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		emf = Persistence.createEntityManagerFactory("JPACitiesTraveled");
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
		emf.close();
	}

	@BeforeEach
	void setUp() throws Exception {
		em = emf.createEntityManager();
		city = em.find(City.class, 1);
	}

	@AfterEach
	void tearDown() throws Exception {
		em.close();
		city = null;
	}

	@Test
	void test_City_entity_mapping() {
		assertNotNull(city);
		assertEquals("Chicago", city.getCity());
	}

}
