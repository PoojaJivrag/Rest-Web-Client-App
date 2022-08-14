package com.BikkadIt.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
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
	
	
	@PostMapping(value="/bookTicket",consumes ="application/json",produces="application/json")
	public ResponseEntity<String>getTicket(@RequestBody Passanger passanger){
	String ticket1=	ticketService.bookTicket(passanger);
	if(ticket1==null) {
		return null;
	}else {
		String msg="Booking Tickets /n"+ticket1;
		return new ResponseEntity<String>(msg,HttpStatus.ACCEPTED);
	}
	
		
	}
	
}
