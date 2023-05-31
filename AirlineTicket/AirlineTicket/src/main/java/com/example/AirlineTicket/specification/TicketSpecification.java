package com.example.AirlineTicket.specification;

import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.data.jpa.domain.Specification;

import com.example.AirlineTicket.entity.Airline;
import com.example.AirlineTicket.entity.Flight;
import com.example.AirlineTicket.entity.Ticket;

import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Join;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;

public class TicketSpecification {
	public static Specification<Ticket> getSqlSpecification(String customer_name,Date fligth_date,String airline_name) {
		return (Root<Ticket> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) -> criteriaBuilder
				.and(getPrediction(query, root, criteriaBuilder, customer_name,fligth_date,airline_name));
	}

	public static Predicate getPrediction(CriteriaQuery<?> query, Root<Ticket> root, CriteriaBuilder criteriaBuilder,
			String customer_name,Date fligth_date,String airline_name) {
		List<Predicate> predicates = new ArrayList<>();
		if (customer_name != null) {
			predicates.add(criteriaBuilder.and(criteriaBuilder.equal(root.get("customerName"), customer_name)));
		}
		if (fligth_date != null) {
			Join<Flight, Ticket> ticketFlight = root.join("flightTicket");
			predicates.add(criteriaBuilder.and(criteriaBuilder.equal(ticketFlight .get("flightDate"), fligth_date)));
		}
		if(airline_name != null) {
			Join<Airline, Ticket> ticketAirline = root.join("airlineTicket");
			predicates.add(criteriaBuilder.and(criteriaBuilder.equal(ticketAirline .get("name"), airline_name)));
		}

		return criteriaBuilder.and(predicates.toArray(new Predicate[predicates.size()]));
		
	}
}
