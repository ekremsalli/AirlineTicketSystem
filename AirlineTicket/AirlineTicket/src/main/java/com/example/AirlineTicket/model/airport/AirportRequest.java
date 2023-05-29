package com.example.AirlineTicket.model.airport;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AirportRequest {
	private String name;
	private String country;
	private String city;
}
