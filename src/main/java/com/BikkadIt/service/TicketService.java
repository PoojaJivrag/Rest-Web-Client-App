package com.BikkadIt.service;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.client.WebClient;

import com.BikkadIt.model.Passanger;
import com.BikkadIt.model.Ticket;

@Service
public class TicketService {

public Ticket bookTicket(Passanger passanger) {
		
		WebClient webClient = WebClient.create();
		  
		String url="http://localhost:9090/bookTicket";
		
		Ticket block = webClient.post()
				 .uri(url)
		         .contentType(MediaType.APPLICATION_JSON)
		         .accept(MediaType.APPLICATION_JSON)
		         .body(BodyInserters.fromValue(passanger))
		         .retrieve()
		         .bodyToMono(Ticket.class)
		         .block();
	
		return block;
	}

}

