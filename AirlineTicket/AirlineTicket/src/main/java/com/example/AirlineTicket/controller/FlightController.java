package com.example.AirlineTicket.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.AirlineTicket.model.flight.FlightRequest;
import com.example.AirlineTicket.model.flight.FlightResponse;
import com.example.AirlineTicket.service.FlightService;

@RestController
@RequestMapping("/flight")
public class FlightController {
	
	private final FlightService flightService;

	public FlightController(FlightService flightService) {
		
		this.flightService = flightService;
	}
	
	@GetMapping("/getAll")
	public List<FlightResponse> getAll(){
		return flightService.getAll();
	}
	
	@PostMapping("/add")
	public void add(@RequestBody() FlightRequest flightRequest) {
		this.flightService.add(flightRequest);
	}
}
