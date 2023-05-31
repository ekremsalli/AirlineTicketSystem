package com.example.AirlineTicket.controller;

import java.sql.Date;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.AirlineTicket.entity.Ticket;
import com.example.AirlineTicket.model.ticket.TicketRequest;
import com.example.AirlineTicket.model.ticket.TicketResponse;
import com.example.AirlineTicket.service.TicketService;

@RestController
@RequestMapping("/ticket")
public class TicketController {
	private final TicketService ticketService;

	public TicketController(TicketService ticketService) {
	
		this.ticketService = ticketService;
	}
	
	@GetMapping("/getAll")
	public List<Ticket> getAll(){
		return ticketService.getAll();
	}
	
	@GetMapping("/getAllByDto")
	public List<TicketResponse> getAllByDto(){
		return ticketService.getAllByDto();
	}
	
	@PostMapping("/add")
	public void add(@RequestBody() TicketRequest ticketRequest) {
		this.ticketService.add(ticketRequest);
	}
	
	
	@GetMapping("/advancedsearch")
	public List<TicketResponse> advancedSearch(@RequestParam(required=false) String customer_name,
											 	   @RequestParam(required=false) String airline_name,
											       @RequestParam(required=false) Date fligth_date,
											       @RequestParam int page,
											       @RequestParam int size) {
		return ticketService.advancedSearch(customer_name,airline_name,fligth_date,page,size);
	}

	
}
