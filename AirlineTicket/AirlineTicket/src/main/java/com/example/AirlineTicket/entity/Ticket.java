package com.example.AirlineTicket.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "ticket")
public class Ticket {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private long id;
	
	@Column(name = "status")
	private boolean status;
	
	@Column(name = "customerName")
	private String customerName;
	
	@Column(name = "cardNo")
	private String cardNo;
	
	@Column(name = "flightFee")
	private long flightFee;

	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "flight_id")
	private Flight flightTicket;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "airline_id")
	private Airline airlineTicket;

	
	public Ticket() {
		super();
	}


	public Ticket(long id, boolean status, String customerName, String cardNo, long flightFee, Flight flightTicket,
			Airline airlineTicket) {
		super();
		this.id = id;
		this.status = status;
		this.customerName = customerName;
		this.cardNo = cardNo;
		this.flightFee = flightFee;
		this.flightTicket = flightTicket;
		this.airlineTicket = airlineTicket;
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


	public String getCustomerName() {
		return customerName;
	}


	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}


	public String getCardNo() {
		return cardNo;
	}


	public void setCardNo(String cardNo) {
		this.cardNo = cardNo;
	}


	public long getFlightFee() {
		return flightFee;
	}


	public void setFlightFee(long flightFee) {
		this.flightFee = flightFee;
	}


	public Flight getFlightTicket() {
		return flightTicket;
	}


	public void setFlightTicket(Flight flightTicket) {
		this.flightTicket = flightTicket;
	}


	public Airline getAirlineTicket() {
		return airlineTicket;
	}


	public void setAirlineTicket(Airline airlineTicket) {
		this.airlineTicket = airlineTicket;
	}


}
