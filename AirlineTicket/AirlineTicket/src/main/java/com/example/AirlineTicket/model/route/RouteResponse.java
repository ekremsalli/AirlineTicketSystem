package com.example.AirlineTicket.model.route;

import com.example.AirlineTicket.model.airport.AirportResponse;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RouteResponse {
	private long id;
	private boolean status;
	private AirportResponse airportRouteTo;
	private AirportResponse airportRouteFrom;
}
