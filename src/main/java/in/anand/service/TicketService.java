package in.anand.service;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import in.anand.response.TicketResponse;
import in.anand.restuest.PassengerRequest;

@Service
public class TicketService {
	
	
	public TicketResponse initiateTicket(PassengerRequest request)
	{
		
		String endpointurl="http://localhost:9090/bookTicket";
		
		RestTemplate restTemplate = new RestTemplate();
		
		ResponseEntity<TicketResponse> responseEntity = restTemplate.postForEntity(endpointurl, request, TicketResponse.class);
		TicketResponse body = responseEntity.getBody();
		
		return body;
		
		
	}

}
