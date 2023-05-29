package com.example.AirlineTicket.model.flight;

import java.sql.Date;

import com.example.AirlineTicket.model.route.RouteResponse;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class FlightResponse {
	private long id;
	private boolean status;
	private Date flightDate;
	private int passangerCount;
	private RouteResponse routeFlight;
}
