package com.example.AirlineTicket.entity;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "airport")
public class Airport {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private long id;
	
	@Column(name = "name")
	private String name;
	
	@Column(name = "country")
	private String country;
	
	@Column(name = "city")
	private String city;
	
	@OneToMany(fetch = FetchType.LAZY,mappedBy = "airportRouteTo")
	private List<Route> routeTo;
	
	@OneToMany(fetch = FetchType.LAZY,mappedBy = "airportRouteFrom")
	private List<Route> routeFrom;
	
	public Airport() {
		super();
	}

	public Airport(long id, String name, String country, String city) {
		super();
		this.id = id;
		this.name = name;
		this.country = country;
		this.city = city;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

}
