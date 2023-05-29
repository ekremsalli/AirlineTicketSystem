package com.example.AirlineTicket.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.AirlineTicket.entity.Airline;
import com.example.AirlineTicket.repository.AirlineRepository;

@Service
public class AirlineService {

	private final AirlineRepository airlineRepository;

	public AirlineService(AirlineRepository airlineRepository) {
		super();
		this.airlineRepository = airlineRepository;
	}
	
	public void add(Airline airline) {
		this.airlineRepository.save(airline);
	}
	
	public List<Airline> getAll(){
		List<Airline> airlines = airlineRepository.findAll();
			
		
		return airlines;
	}
}
