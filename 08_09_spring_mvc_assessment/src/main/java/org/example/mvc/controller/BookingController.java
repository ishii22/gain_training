package org.example.mvc.controller;

import org.example.mvc.dao.BookingDAO;
import org.example.mvc.dao.PassengerDAO;
import org.example.mvc.entity.Bookings;
import org.example.mvc.entity.Passengers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class BookingController {

	@Autowired
	BookingDAO bdao;
	
	@Autowired
	PassengerDAO pdao;
	
	@GetMapping("/bookFlight")
	public String bookFlight(@RequestParam String bookingId,@RequestParam String flightId, @RequestParam String passengerId, @RequestParam String firstName,@RequestParam String lastName,@RequestParam long mobile,@RequestParam String email,@RequestParam String travelDate,Model model) {
		String message = "Flight Booking  F A I L E D!";
		if(bdao.addBookingDetails(new Bookings(bookingId,flightId,passengerId, travelDate))
				&& pdao.addPassengerDetails(new Passengers(passengerId,firstName,lastName,mobile,email)))
			message = "Flight Booking Successful!! ";
		model.addAttribute("message",message);
		return "DisplayFlightStatus";
	}
	
	@GetMapping("/displayFlightStatus")
	public String displayFlightStatus(@RequestParam String bookingId,Model model) {
		
		Bookings b=bdao.getBookingByBookingId(bookingId);
		String message="Booking Id: "+b.getBookingId()
				+" Flight Id: "+ b.getFlightId()
				+" Passenger Id:"+b.getPassengerId()
				+" Travel Date: "+b.getDate();
		model.addAttribute("message", message);
		return "Display";
	}
	
}
