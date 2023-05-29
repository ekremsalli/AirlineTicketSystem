package com.example.AirlineTicket.service;

import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import com.example.AirlineTicket.entity.Ticket;
import com.example.AirlineTicket.repository.TicketRepository;
import com.example.AirlineTicket.specification.TicketSpecificaiton;

@Service
public class TicketService {

	private final TicketRepository ticketRepository;

	public TicketService(TicketRepository ticketRepository) {
		super();
		this.ticketRepository = ticketRepository;
	}
	
	public void add(Ticket ticket) {
		this.ticketRepository.save(ticket);
	}
	
	public List<Ticket> getAll(){
		List<Ticket> tickets = ticketRepository.findAll();
		
		return tickets;
	}
	
	public List<Ticket> advancedSearch(String customer_name,String airline_name,Date fligth_date,int page,int size) {
		Specification<Ticket> ticketSpecification = TicketSpecificaiton.getSqlSpecification(customer_name,fligth_date,airline_name);
		Pageable pageRequest = PageRequest.of(page, size);
		Page<Ticket> ticketsPage = ticketRepository.findAll(ticketSpecification ,pageRequest);
		List<Ticket> tickets = new ArrayList<Ticket>();
		tickets = ticketsPage.getContent();

		return tickets;
	}
}
