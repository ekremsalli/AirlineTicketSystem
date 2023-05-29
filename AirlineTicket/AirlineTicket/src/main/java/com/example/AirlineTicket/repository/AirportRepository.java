package com.example.AirlineTicket.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.AirlineTicket.entity.Airport;

public interface AirportRepository extends JpaRepository<Airport, Long> {
	
}
