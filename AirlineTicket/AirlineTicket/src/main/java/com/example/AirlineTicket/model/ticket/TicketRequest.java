package com.example.AirlineTicket.model.ticket;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TicketRequest {
	private boolean status;
	private String customerName;
	private String cardNo;
	private long flightFee;
	private long airlineTicket_id;
	private long flightTicket_id;
}
