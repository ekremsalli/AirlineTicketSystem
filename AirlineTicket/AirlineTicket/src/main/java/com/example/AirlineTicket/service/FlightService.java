package com.example.AirlineTicket.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.AirlineTicket.entity.Airport;
import com.example.AirlineTicket.entity.Flight;
import com.example.AirlineTicket.model.airport.AirportResponse;
import com.example.AirlineTicket.model.flight.FlightRequest;
import com.example.AirlineTicket.model.flight.FlightResponse;
import com.example.AirlineTicket.model.route.RouteResponse;
import com.example.AirlineTicket.repository.FlightRepository;
import com.example.AirlineTicket.repository.RouteRepository;

@Service
public class FlightService {

	private final FlightRepository flightRepository;
	private final RouteService routeService;

	public FlightService(FlightRepository flightRepository,RouteService routeService) {
		this.routeService = routeService;
		this.flightRepository = flightRepository;
	}
	
	public void add(FlightRequest flightRequest) {
		Flight flight = new Flight();
		
		flight.setPassangerCount(flightRequest.getPassangerCount());
		flight.setStatus(flightRequest.isStatus());
		flight.setFlightDate(flightRequest.getFlightDate());
		
		flight.setRouteFlight(routeService.finById(flightRequest.getRoute_id()));
		
		
		this.flightRepository.save(flight);
	}
	
	public List<FlightResponse> getAll(){
		List<Flight> flights = flightRepository.findAll();
		List<FlightResponse> flightResponses = new ArrayList<FlightResponse>();
		
		for(Flight f:flights) {
			
			FlightResponse flightResponse = new FlightResponse();
			
			flightResponse.setId(f.getId());
			flightResponse.setFlightDate(f.getFlightDate());
			flightResponse.setPassangerCount(f.getPassangerCount());
			flightResponse.setStatus(f.isStatus());
			
				RouteResponse routeResponse = new RouteResponse();
				routeResponse.setId(f.getRouteFlight().getId());
				routeResponse.setStatus(f.getRouteFlight().isStatus());
			
					AirportResponse airportRouteTo = new AirportResponse();
					airportRouteTo.setId(f.getRouteFlight().getAirportRouteTo().getId());
					airportRouteTo.setCity(f.getRouteFlight().getAirportRouteTo().getCity());
					airportRouteTo.setCountry(f.getRouteFlight().getAirportRouteTo().getCountry());
					airportRouteTo.setName(f.getRouteFlight().getAirportRouteTo().getName());
					
					AirportResponse airportRouteFrom = new AirportResponse();
					airportRouteFrom.setId(f.getRouteFlight().getAirportRouteFrom().getId());
					airportRouteFrom.setCity(f.getRouteFlight().getAirportRouteFrom().getCity());
					airportRouteFrom.setCountry(f.getRouteFlight().getAirportRouteFrom().getCountry());
					airportRouteFrom.setName(f.getRouteFlight().getAirportRouteFrom().getName());
					
				routeResponse.setAirportRouteTo(airportRouteTo);
				routeResponse.setAirportRouteFrom(airportRouteFrom);
			
			flightResponse.setRouteFlight(routeResponse);
			
			
			flightResponses.add(flightResponse);
		}
		
		return flightResponses;
	}
	
	public Flight findById(Long id) {
		Optional<Flight> flight = flightRepository.findById(id);
		return flight.get();
	}
}

















