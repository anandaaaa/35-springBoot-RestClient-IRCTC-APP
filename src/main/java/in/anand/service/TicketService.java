package in.anand.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import in.anand.response.TicketResponse;
import in.anand.restuest.PassengerRequest;

@Service
public class TicketService {
	

	@Autowired
	private RestTemplate rts;
	
	public TicketResponse initiateTicket(PassengerRequest request)
	{
		
		String endpointurl="http://localhost:9090/bookTicket";
		
		HttpHeaders header= new HttpHeaders();
		header.set("Content-Type", "application/json");
		header.set("Accept","application/xml");
		HttpEntity<PassengerRequest> httpEntity = new HttpEntity<>(request,header);

		
		//RestTemplate restTemplate = new RestTemplate();
		
		ResponseEntity<TicketResponse> responseEntity =	rts.postForEntity(endpointurl, httpEntity, TicketResponse.class);

				//restTemplate.postForEntity(endpointurl, httpEntity, TicketResponse.class);
		TicketResponse body = responseEntity.getBody();
		
		return body;
		
		
	}

}
