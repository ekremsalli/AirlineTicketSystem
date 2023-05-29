package com.example.AirlineTicket.entity;

import java.sql.Date;
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
@Table(name ="flight")
public class Flight {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private long id;
	
	@Column(name = "status")
	private boolean status;
	
	@Column(name = "flightDate")
	private Date flightDate;
	
	@Column(name = "passangerCounts")
	private int passangerCount;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name ="route_id")
	private Route routeFlight;
	
	@OneToMany(fetch = FetchType.LAZY,mappedBy = "flightTicket")
	private List<Ticket> flightTickets;
	
	public Flight() {
		super();
	}

	public Flight(long id, boolean status, Date flightDate, int passangerCount, Route routeFlight) {
		super();
		this.id = id;
		this.status = status;
		this.flightDate = flightDate;
		this.passangerCount = passangerCount;
		this.routeFlight = routeFlight;

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

	public Date getFlightDate() {
		return flightDate;
	}

	public void setFlightDate(Date flightDate) {
		this.flightDate = flightDate;
	}

	public int getPassangerCount() {
		return passangerCount;
	}

	public void setPassangerCount(int passangerCount) {
		this.passangerCount = passangerCount;
	}

	public Route getRouteFlight() {
		return routeFlight;
	}

	public void setRouteFlight(Route routeFlight) {
		this.routeFlight = routeFlight;
	}

	
}
