package com.BikkadIt.service;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.client.WebClient;

import com.BikkadIt.model.Passanger;
import com.BikkadIt.model.Ticket;

@Service
public class TicketService {

public String bookTicket(Passanger passanger) {
	
	//RestTemplate rt= new RestTemplate();
	
	WebClient webClient = WebClient.create();
		  
		String url="http://localhost:9090/getTicket";
		
		String block = webClient.post()
				 .uri(url)
		         .contentType(MediaType.APPLICATION_JSON)
		         .accept(MediaType.APPLICATION_JSON)
		         .body(BodyInserters.fromValue(passanger))
		         .retrieve()
		         .bodyToMono(String.class)
		         .block();
		System.out.println(block);
	
		return block;
	}



//public String BookTicketASyn(Passanger passanger) {
//	
//	
//	WebClient webClient = WebClient.create();
//	  
//	String url="http://mu.mulesoft-training.com/essentials/united/flights";
//	
//	 webClient.get()
//	         .uri(url)
//	         .accept(MediaType.APPLICATION_JSON)
//	         .retrieve()
//	         .bodyToMono(String.class)
//	         .subscribe(System.out::println);
//	
//	System.out.println("Welcome to Bikkad IT");
//	return url;
//}



}

