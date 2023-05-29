package com.example.AirlineTicket.model.ticket;

import com.example.AirlineTicket.model.airline.AirlineResponse;
import com.example.AirlineTicket.model.flight.FlightResponse;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TicketResponse {
	private long id;
	private boolean status;
	private String customerName;
	private String cardNo;
	private long flightFee;
	private AirlineResponse airlineTicket;
	private FlightResponse flightTicket;
}
