package com.example.AirlineTicket.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.AirlineTicket.entity.Airline;
import com.example.AirlineTicket.service.AirlineService;

@RestController
@RequestMapping("/airline")
public class AirlineController {

	private final AirlineService airlineService;
	

	public AirlineController(AirlineService airlineService) {
		super();
		this.airlineService = airlineService;
	}


	@GetMapping("/getAll")
	public List<Airline> getAll() {
		
		return airlineService.getAll();
	}
	
	@PostMapping("/add")
	public void add(@RequestBody() Airline airline){
		this.airlineService.add(airline);
	}

}
