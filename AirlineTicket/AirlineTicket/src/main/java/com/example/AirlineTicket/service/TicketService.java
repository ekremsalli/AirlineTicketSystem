package com.example.AirlineTicket.service;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import com.example.AirlineTicket.entity.Ticket;
import com.example.AirlineTicket.model.airline.AirlineResponse;
import com.example.AirlineTicket.model.airport.AirportResponse;
import com.example.AirlineTicket.model.flight.FlightResponse;
import com.example.AirlineTicket.model.route.RouteResponse;
import com.example.AirlineTicket.model.ticket.TicketRequest;
import com.example.AirlineTicket.model.ticket.TicketResponse;
import com.example.AirlineTicket.repository.TicketRepository;
import com.example.AirlineTicket.specification.TicketSpecification;

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
	
	public List<TicketResponse> getAllByDto(){
		List<Ticket> tickets = ticketRepository.findAll();
		List<TicketResponse> ticketResponses = new ArrayList<TicketResponse>();
		for(Ticket t:tickets) {
			
			TicketResponse ticketResponse = new TicketResponse();
			ticketResponse.setId(t.getId());
			ticketResponse.setStatus(t.isStatus());
			ticketResponse.setCustomerName(t.getCustomerName());
			ticketResponse.setCardNo(t.getCardNo());
			ticketResponse.setFlightFee(t.getFlightFee());
		
				AirlineResponse airlineResponse = new AirlineResponse();
				airlineResponse.setId(t.getAirlineTicket().getId());
				airlineResponse.setName(t.getAirlineTicket().getName());
				airlineResponse.setCompanyAdsress(t.getAirlineTicket().getCompanyAddress());
				
			ticketResponse.setAirlineTicket(airlineResponse);
			
				FlightResponse flightResponse = new FlightResponse();
				flightResponse.setId(t.getFlightTicket().getId());
				flightResponse.setStatus(t.getFlightTicket().isStatus());
				flightResponse.setFlightDate(t.getFlightTicket().getFlightDate());
				flightResponse.setPassangerCount(t.getFlightTicket().getPassangerCount());
				
					RouteResponse routeResponse = new RouteResponse();
					routeResponse.setId(t.getFlightTicket().getRouteFlight().getId());
					routeResponse.setStatus(t.getFlightTicket().getRouteFlight().isStatus());
					
						AirportResponse airportResponseTo = new AirportResponse();
						airportResponseTo.setId(t.getFlightTicket().getRouteFlight().getAirportRouteTo().getId());
						airportResponseTo.setName(t.getFlightTicket().getRouteFlight().getAirportRouteTo().getName());
						airportResponseTo.setCity(t.getFlightTicket().getRouteFlight().getAirportRouteTo().getCity());
						airportResponseTo.setCountry(t.getFlightTicket().getRouteFlight().getAirportRouteTo().getCountry());
						
					routeResponse.setAirportRouteTo(airportResponseTo);
					
						AirportResponse airportResponseFrom = new AirportResponse();
						airportResponseFrom.setId(t.getFlightTicket().getRouteFlight().getAirportRouteFrom().getId());
						airportResponseFrom.setName(t.getFlightTicket().getRouteFlight().getAirportRouteFrom().getName());
						airportResponseFrom.setCity(t.getFlightTicket().getRouteFlight().getAirportRouteFrom().getCity());
						airportResponseFrom.setCountry(t.getFlightTicket().getRouteFlight().getAirportRouteFrom().getCountry());
						
					routeResponse.setAirportRouteFrom(airportResponseFrom);
					
				flightResponse.setRouteFlight(routeResponse);
				
			ticketResponse.setFlightTicket(flightResponse);
			
			
			
			ticketResponses.add(ticketResponse);
		}
		return ticketResponses;
	}
	
	
	
	public List<TicketResponse> advancedSearch(String customer_name,String airline_name,Date fligth_date,int page,int size) {
		
		Specification<Ticket> ticketSpecification = TicketSpecification.getSqlSpecification(customer_name,fligth_date,airline_name);
		Pageable pageRequest = PageRequest.of(page, size);
		Page<Ticket> ticketPage = ticketRepository.findAll(ticketSpecification,pageRequest);
		List<Ticket> tickets = new ArrayList<Ticket>();
		tickets = ticketPage.getContent();
		List<TicketResponse> ticketResponses = new ArrayList<TicketResponse>();
		
		for(Ticket t:tickets) {
			
			TicketResponse ticketResponse = new TicketResponse();
			ticketResponse.setId(t.getId());
			ticketResponse.setStatus(t.isStatus());
			ticketResponse.setCustomerName(t.getCustomerName());
			ticketResponse.setCardNo(t.getCardNo());
			ticketResponse.setFlightFee(t.getFlightFee());
		
				AirlineResponse airlineResponse = new AirlineResponse();
				airlineResponse.setId(t.getAirlineTicket().getId());
				airlineResponse.setName(t.getAirlineTicket().getName());
				airlineResponse.setCompanyAdsress(t.getAirlineTicket().getCompanyAddress());
				
			ticketResponse.setAirlineTicket(airlineResponse);
			
				FlightResponse flightResponse = new FlightResponse();
				flightResponse.setId(t.getFlightTicket().getId());
				flightResponse.setStatus(t.getFlightTicket().isStatus());
				flightResponse.setFlightDate(t.getFlightTicket().getFlightDate());
				flightResponse.setPassangerCount(t.getFlightTicket().getPassangerCount());
				
					RouteResponse routeResponse = new RouteResponse();
					routeResponse.setId(t.getFlightTicket().getRouteFlight().getId());
					routeResponse.setStatus(t.getFlightTicket().getRouteFlight().isStatus());
					
						AirportResponse airportResponseTo = new AirportResponse();
						airportResponseTo.setId(t.getFlightTicket().getRouteFlight().getAirportRouteTo().getId());
						airportResponseTo.setName(t.getFlightTicket().getRouteFlight().getAirportRouteTo().getName());
						airportResponseTo.setCity(t.getFlightTicket().getRouteFlight().getAirportRouteTo().getCity());
						airportResponseTo.setCountry(t.getFlightTicket().getRouteFlight().getAirportRouteTo().getCountry());
						
					routeResponse.setAirportRouteTo(airportResponseTo);
					
						AirportResponse airportResponseFrom = new AirportResponse();
						airportResponseFrom.setId(t.getFlightTicket().getRouteFlight().getAirportRouteFrom().getId());
						airportResponseFrom.setName(t.getFlightTicket().getRouteFlight().getAirportRouteFrom().getName());
						airportResponseFrom.setCity(t.getFlightTicket().getRouteFlight().getAirportRouteFrom().getCity());
						airportResponseFrom.setCountry(t.getFlightTicket().getRouteFlight().getAirportRouteFrom().getCountry());
						
					routeResponse.setAirportRouteFrom(airportResponseFrom);
					
				flightResponse.setRouteFlight(routeResponse);
				
			ticketResponse.setFlightTicket(flightResponse);
			
			
			
			ticketResponses.add(ticketResponse);
		}
		return ticketResponses;
	}
}
