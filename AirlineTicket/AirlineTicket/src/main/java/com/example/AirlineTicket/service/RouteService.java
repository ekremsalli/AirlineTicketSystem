package com.example.AirlineTicket.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.AirlineTicket.entity.Route;
import com.example.AirlineTicket.repository.RouteRepository;

@Service
public class RouteService {

	private final RouteRepository routeRepository;

	public RouteService(RouteRepository routeRepository) {
		super();
		this.routeRepository = routeRepository;
	}
	
	public void add(Route route) {
		this.routeRepository.save(route);
	}
	
	public List<Route> getAll(){
		List<Route> routes = routeRepository.findAll();
		
		return routes;
	}
}
