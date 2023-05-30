package com.example.AirlineTicket.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.AirlineTicket.entity.Route;
import com.example.AirlineTicket.model.airport.AirportResponse;
import com.example.AirlineTicket.model.route.RouteRequest;
import com.example.AirlineTicket.model.route.RouteResponse;
import com.example.AirlineTicket.repository.RouteRepository;

@Service
public class RouteService {

	private final RouteRepository routeRepository;
	private final AirportService airportService;

	public RouteService(RouteRepository routeRepository,AirportService airportService) {
		this.routeRepository = routeRepository;
		this.airportService = airportService;
	}
	
	public void add(RouteRequest routeRequest) {
		Route route = new Route();
		route.setStatus(routeRequest.isStatus());
		route.setAirportRouteFrom(airportService.findById(routeRequest.getAirportRouteFrom_id()));
		route.setAirportRouteTo(airportService.findById(routeRequest.getAirportRouteTo_id()));
		
		this.routeRepository.save(route);
	}
	
	public List<RouteResponse> getAll(){
		List<Route> routes = routeRepository.findAll();
		List<RouteResponse> routeResponses = new ArrayList<RouteResponse>();
		
		for(Route r:routes) {
			RouteResponse routeResponse = new RouteResponse();
			
			routeResponse.setId(r.getId());
			routeResponse.setStatus(r.isStatus());
			
			AirportResponse airportTo = new AirportResponse();
			airportTo.setId(r.getAirportRouteTo().getId());
			airportTo.setName(r.getAirportRouteTo().getName());
			airportTo.setCity(r.getAirportRouteTo().getCity());
			airportTo.setCountry(r.getAirportRouteTo().getCountry());
			
			
			AirportResponse airportFrom = new AirportResponse();
			airportFrom.setId(r.getAirportRouteFrom().getId());
			airportFrom.setName(r.getAirportRouteFrom().getName());
			airportFrom.setCity(r.getAirportRouteFrom().getCity());
			airportFrom.setCountry(r.getAirportRouteFrom().getCountry());
			
			routeResponse.setAirportRouteFrom(airportFrom);
			routeResponse.setAirportRouteTo(airportTo);
			
			
			routeResponses.add(routeResponse);
		}
		
		return routeResponses;
	}
	
	public Route finById(Long id) {
		Optional<Route> route = routeRepository.findById(id);
		return route.get();
	}
}
