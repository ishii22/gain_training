package org.example.mvc.controller;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletResponse;

import org.example.mvc.dao.UserDAO;
import org.example.mvc.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LoginController 
{
	@Autowired
	UserDAO udao;
	
	@GetMapping("/loginPage")
	public String getLoginPage() 
	{
		return "Login";
	}
	@PostMapping("/validateUser")
	public String authenticateUser(@RequestParam("uname")String username, @RequestParam("pword")String password, Model model, HttpServletResponse response) {
		
		String message = "Invalid Username/Password...Try Again...!";
		User user = new User(username,password);
		if(udao.validateUser(user)) {
			Cookie c = new Cookie("username",username);
			response.addCookie(c);
			return "SearchFlightBySourceDestination";
		}
		model.addAttribute("message",message);
		return "Display";
	}
	
	
}
