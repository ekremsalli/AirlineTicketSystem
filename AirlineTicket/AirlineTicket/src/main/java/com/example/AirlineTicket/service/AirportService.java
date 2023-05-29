package com.example.AirlineTicket.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.AirlineTicket.entity.Airport;
import com.example.AirlineTicket.repository.AirportRepository;

@Service
public class AirportService {

	private final AirportRepository airportRepository;

	public AirportService(AirportRepository airportRepository) {
		super();
		this.airportRepository = airportRepository;
	}
	
	public void add(Airport airport) {
		this.airportRepository.save(airport);
	}
	
	public List<Airport> getAll(){
		List<Airport> airports = airportRepository.findAll();
		
		return airports;
	}
}
