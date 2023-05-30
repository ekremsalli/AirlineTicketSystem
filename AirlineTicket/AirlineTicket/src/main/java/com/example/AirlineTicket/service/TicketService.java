package com.example.AirlineTicket.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.AirlineTicket.entity.Ticket;
import com.example.AirlineTicket.model.ticket.TicketRequest;
import com.example.AirlineTicket.repository.TicketRepository;

@Service
public class TicketService {

	private final TicketRepository ticketRepository;
	private final AirlineService airlineService;
	private final FlightService flightService;

	public TicketService(TicketRepository ticketRepository,FlightService flightService,AirlineService airlineService) {
		this.flightService = flightService;
		this.airlineService = airlineService;
		this.ticketRepository = ticketRepository;
	}
	
	public void add(TicketRequest ticketRequest) {
		Ticket ticket = new Ticket();
		
		ticket.setStatus(ticketRequest.isStatus());
		ticket.setCustomerName(ticketRequest.getCustomerName());
		ticket.setCardNo(ticketRequest.getCardNo());
		ticket.setFlightFee(ticketRequest.getFlightFee());
		ticket.setFlightTicket(flightService.findById(ticketRequest.getFlightTicket_id()));
		ticket.setAirlineTicket(airlineService.findById(ticketRequest.getAirlineTicket_id()));
		
		this.ticketRepository.save(ticket);
	}
	
	public List<Ticket> getAll(){
		List<Ticket> tickets = ticketRepository.findAll();
		
		return tickets;
	}
	
}
