package com.example.AirlineTicket.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.AirlineTicket.entity.Route;

public interface RouteRepository extends JpaRepository<Route, Long> {
	
}
