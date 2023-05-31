package com.example.AirlineTicket.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.AirlineTicket.model.route.RouteRequest;
import com.example.AirlineTicket.model.route.RouteResponse;
import com.example.AirlineTicket.service.RouteService;

@RestController
@RequestMapping("/route")
public class RouteController {
	private final RouteService routeService;

	public RouteController(RouteService routeService) {
	
		this.routeService = routeService;
	}
	
	@GetMapping("/getAll")
	public List<RouteResponse> getAll(){
		return routeService.getAll();
	}
	
	@PostMapping("/add")
	public void add(@RequestBody() RouteRequest routeRequest) {
		this.routeService.add(routeRequest);
	}
}
