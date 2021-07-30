package in.anand.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import in.anand.response.TicketResponse;
import in.anand.restuest.PassengerRequest;
import in.anand.service.TicketService;

@RestController
public class BookTicketController {
	
	@Autowired
	private TicketService service;
	
	@PostMapping("/book")
	public TicketResponse callTicketService(@RequestBody PassengerRequest request)
	{			System.out.println("called");

		TicketResponse ticketResponse = service.initiateTicket(request);
		System.out.println(ticketResponse);
		return ticketResponse;
	}

}
