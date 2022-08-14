package com.BikkadIt.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.BikkadIt.model.Passanger;
import com.BikkadIt.model.Ticket;
import com.BikkadIt.service.TicketService;

@RestController
public class Passangercontroller {
    
	@Autowired
	private TicketService  ticketService;
	
	public ResponseEntity<String>getTicket(@RequestBody Passanger passanger){
	Ticket ticket=	ticketService.bookTicket(passanger);
	if(ticket==null) {
		return null;
	}else {
		String msg="Booking Tickets /n"+ticket;
		return new ResponseEntity<String>(msg,HttpStatus.ACCEPTED);
	}
	
		
	}
	
}
