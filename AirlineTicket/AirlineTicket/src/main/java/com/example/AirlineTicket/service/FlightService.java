package com.example.AirlineTicket.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.AirlineTicket.entity.Flight;
import com.example.AirlineTicket.repository.FlightRepository;

@Service
public class FlightService {

	private final FlightRepository flightRepository;

	public FlightService(FlightRepository flightRepository) {
		super();
		this.flightRepository = flightRepository;
	}
	
	public void add(Flight Flight) {
		this.flightRepository.save(Flight);
	}
	
	public List<Flight> getAll(){
		List<Flight> flights = flightRepository.findAll();
		
		return flights;
	}
}
