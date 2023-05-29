package com.example.AirlineTicket.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.AirlineTicket.entity.Airline;

public interface AirlineRepository extends JpaRepository<Airline,Long>{

}
