package com.example.AirlineTicket.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.AirlineTicket.entity.Airline;
import com.example.AirlineTicket.entity.Airport;
import com.example.AirlineTicket.model.airline.AirlineRequest;
import com.example.AirlineTicket.model.airline.AirlineResponse;
import com.example.AirlineTicket.repository.AirlineRepository;

@Service
public class AirlineService {

	private final AirlineRepository airlineRepository;

	public AirlineService(AirlineRepository airlineRepository) {
		this.airlineRepository = airlineRepository;
	}
	
	public void add(AirlineRequest airlineRequest) {
		Airline airline = new Airline();
		
		airline.setName(airlineRequest.getName());
		airline.setCompanyAddress(airlineRequest.getCompanyAdsress());
		
		this.airlineRepository.save(airline);
	}
	
	public List<AirlineResponse> getAll(){
		List<Airline> airlines = airlineRepository.findAll();
		List<AirlineResponse> airlineResponses = new ArrayList<AirlineResponse>();
		
		for(Airline a:airlines) {
			
			AirlineResponse airlineResponse = new AirlineResponse();
			airlineResponse.setId(a.getId());
			airlineResponse.setName(a.getName());
			airlineResponse.setCompanyAdsress(a.getCompanyAddress());
			
			airlineResponses.add(airlineResponse);
		}
		
		return airlineResponses;
	}
	
	public Airline findById(Long id) {
		Optional<Airline> airline = airlineRepository.findById(id);
		return airline.get();
	}
}
