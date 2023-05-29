package com.example.AirlineTicket.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.AirlineTicket.entity.Flight;


public interface FlightRepository extends JpaRepository<Flight, Long> {
	
}
