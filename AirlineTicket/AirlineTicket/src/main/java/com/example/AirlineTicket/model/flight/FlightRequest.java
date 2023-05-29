package com.example.AirlineTicket.model.flight;

import java.sql.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class FlightRequest {
	private boolean status;
	private Date flightDate;
	private int passangerCount;
	private long route_id;
}
