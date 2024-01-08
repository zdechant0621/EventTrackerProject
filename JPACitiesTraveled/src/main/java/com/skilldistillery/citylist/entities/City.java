package com.skilldistillery.citylist.entities;

import java.util.Date;
import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class City {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String city;
	@Column(name = "state_country")
	private String stateCountry;
	private String description;
	@Column(name = "arrival_date")
	private Date arrivalDate;
	@Column(name = "departure_date")
	private Date departureDate;
	@Column(name = "shot_glass_bought")
	private boolean shotGlassBought;
	private boolean enabled;
	

	public City() {
		super();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getStateCountry() {
		return stateCountry;
	}

	public void setStateCountry(String stateCountry) {
		this.stateCountry = stateCountry;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Date getArrivalDate() {
		return arrivalDate;
	}

	public void setArrivalDate(Date arrivalDate) {
		this.arrivalDate = arrivalDate;
	}

	public Date getDepartureDate() {
		return departureDate;
	}

	public void setDepartureDate(Date departureDate) {
		this.departureDate = departureDate;
	}

	public boolean isShotGlassBought() {
		return shotGlassBought;
	}

	public void setShotGlassBought(boolean shotGlassBought) {
		this.shotGlassBought = shotGlassBought;
	}

	public boolean isEnabled() {
		return enabled;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		City other = (City) obj;
		return id == other.id;
	}

	@Override
	public String toString() {
		return "City [id=" + id + ", city=" + city + ", stateCountry=" + stateCountry + ", description=" + description
				+ ", arrivalDate=" + arrivalDate + ", departureDate=" + departureDate + ", shotGlassBought="
				+ shotGlassBought + ", enabled=" + enabled + "]";
	}

}
