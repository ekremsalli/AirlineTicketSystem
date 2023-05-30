package com.example.AirlineTicket.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.AirlineTicket.entity.Airport;
import com.example.AirlineTicket.model.airport.AirportRequest;
import com.example.AirlineTicket.model.airport.AirportResponse;
import com.example.AirlineTicket.repository.AirportRepository;

@Service
public class AirportService {

	private final AirportRepository airportRepository;

	public AirportService(AirportRepository airportRepository) {
		super();
		this.airportRepository = airportRepository;
	}
	
	public void add(AirportRequest airportRequest) {
		Airport airport = new Airport();
		
		airport.setName(airportRequest.getName());
		airport.setCountry(airportRequest.getCountry());
		airport.setCity(airportRequest.getCity());
		
		
		this.airportRepository.save(airport);
	}
	
	public List<AirportResponse> getAll(){
		List<Airport> airports = airportRepository.findAll();
		List<AirportResponse> airportResponses = new ArrayList<AirportResponse>();
		
		for(Airport a:airports) {
			AirportResponse airportResponse = new AirportResponse();
			
			airportResponse.setId(a.getId());
			airportResponse.setName(a.getName());
			airportResponse.setCity(a.getCity());
			airportResponse.setCountry(a.getCountry());
			
			airportResponses.add(airportResponse);
		}
		
		return airportResponses;
	}
	
	public Airport findById(Long id) {
		Optional<Airport> airport = airportRepository.findById(id);
		return airport.get();
	}
}
