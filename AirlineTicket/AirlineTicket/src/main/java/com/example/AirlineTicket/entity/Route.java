package com.example.AirlineTicket.entity;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "route")
public class Route {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private long id;
	
	@Column(name = "status")
	private boolean status;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "airport_route_to")
	private Airport airportRouteTo;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "airport_route_from")
	private Airport airportRouteFrom;
	
	@OneToMany(fetch = FetchType.LAZY,mappedBy = "routeFlight")
	private List<Flight> routeFlights;
	

	
	public Route() {
		super();
	}

	public Route(long id, boolean status, Airport airportRouteTo, Airport airportRouteFrom) {
		super();
		this.id = id;
		this.status = status;
		this.airportRouteTo = airportRouteTo;
		this.airportRouteFrom = airportRouteFrom;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	public Airport getAirportRouteTo() {
		return airportRouteTo;
	}

	public void setAirportRouteTo(Airport airportRouteTo) {
		this.airportRouteTo = airportRouteTo;
	}

	public Airport getAirportRouteFrom() {
		return airportRouteFrom;
	}

	public void setAirportRouteFrom(Airport airportRouteFrom) {
		this.airportRouteFrom = airportRouteFrom;
	}

}
