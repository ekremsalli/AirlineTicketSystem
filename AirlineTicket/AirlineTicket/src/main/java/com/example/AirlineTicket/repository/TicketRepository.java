package com.example.AirlineTicket.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.example.AirlineTicket.entity.Ticket;

public interface TicketRepository extends JpaRepository<Ticket, Long>,JpaSpecificationExecutor<Ticket> {
	
}
