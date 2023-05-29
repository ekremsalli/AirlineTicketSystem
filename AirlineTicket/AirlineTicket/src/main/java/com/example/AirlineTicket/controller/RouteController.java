package com.example.AirlineTicket.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.AirlineTicket.entity.Route;
import com.example.AirlineTicket.service.RouteService;

@RestController
@RequestMapping("/route")
public class RouteController {
	private final RouteService routeService;

	public RouteController(RouteService routeService) {
		super();
		this.routeService = routeService;
	}
	
	@GetMapping("/getAll")
	public List<Route> getAll(){
		return routeService.getAll();
	}
	
	@PostMapping("/add")
	public void add(@RequestBody() Route route) {
		this.routeService.add(route);
	}
}
