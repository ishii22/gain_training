package org.example.mvc.controller;

import java.util.ArrayList;

import org.example.mvc.dao.FlightDAO;
import org.example.mvc.entity.Flight;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class FlightController {
	
	@Autowired
	FlightDAO fdao;
	
	@GetMapping("/showFlightsBySourceAndDestination")
	public String showFlightsBySourceDestination(@RequestParam String source, @RequestParam String destination,Model model) {
		ArrayList<Flight> flist = new ArrayList<>();
		flist = fdao.findFlightBySourceDestination(source, destination);
		model.addAttribute("flist",flist);
		return "FlightBooking";
	}
	
	

}
