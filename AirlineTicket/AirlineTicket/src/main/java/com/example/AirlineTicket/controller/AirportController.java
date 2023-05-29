package com.example.AirlineTicket.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.AirlineTicket.entity.Airport;
import com.example.AirlineTicket.service.AirportService;

@RestController
@RequestMapping("/airport")
public class AirportController {
	private final AirportService airportService;

	public AirportController(AirportService airportService) {
		super();
		this.airportService = airportService;
	}
	
	@GetMapping("/getAll")
	public List<Airport> getAll(){
		return airportService.getAll();
	}
	
	@PostMapping("/add")
	public void add(@RequestBody() Airport airport) {
		this.airportService.add(airport);
	}
}
