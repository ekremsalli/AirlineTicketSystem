package com.example.AirlineTicket.model.route;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RouteRequest {
	private boolean status;
	private long airportRouteTo_id;
	private long airportRouteFrom_id;
}
