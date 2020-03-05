package com.controller;

import java.util.*;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import com.service.TicketService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.model.Login;
import com.model.Ticket;
import com.model.AdminLogin;;

@Controller
public class TicketController {

	@Autowired
	private TicketService ticketService;
	@Autowired
	JdbcTemplate jdbc;

	@ModelAttribute("radio")
	public List<String> radioOptions() {
		List<String> radio = new ArrayList();
		radio.add("Male");
		radio.add("Female");
		return radio;
	}

	
	
	
	
	@PostMapping("/")
	public String checkPersonInfo(@Valid Ticket ticket, BindingResult bindingResult) {

		if (bindingResult.hasErrors()) {
			return "showpage";
		}

		return "redirect:/sucessful";
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	@RequestMapping(value = "/showpage", method = RequestMethod.GET)
	public String showPage(@ModelAttribute("ticket") Ticket ticket) {
		ticket = new Ticket();
		return "showpage";
	}

	@RequestMapping(value = "/userdata", method = RequestMethod.POST)
	public String calculateTotalCost(@ModelAttribute("ticket") Ticket ticket, ModelMap model, BindingResult result) {

		if (!ticket.getCpassword().equals(ticket.getPassword())) {
			model.put("passerror", "password do not match!");
			return "showpage";
		} else {
			TicketService tk = new TicketService();
			String error = tk.check(ticket);
			List result1 = jdbc.queryForList(error);
			// System.out.println("result " + result1);
			if (!result1.isEmpty()) {
				model.put("Error", "User Already Exist!!!");
				return "showpage";

			} else {
				String str = tk.insert(ticket);
				jdbc.execute(str);

				return "Mainpage";
			}

		}
	}

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String showLoginPage(@ModelAttribute("login") Login login) {
		return "login";
	}

	@RequestMapping(value = "/loginentry", method = RequestMethod.POST)
	public String LoginPost(@ModelAttribute("login") Login login, ModelMap model, BindingResult result) {
		TicketService tk = new TicketService();
		String str = tk.loginCheck(login);
		List result1 = jdbc.queryForList(str);
		System.out.println("result1" + result1);
		if (result1.isEmpty()) {
			model.put("error", "Wrong Credential!!");
			return "login";
		} else {
			model.put("msg", "User");
			return "sucessful";
		}

	}

	@RequestMapping(value = "/adminlogin", method = RequestMethod.GET)
	public String AdminLogin(@ModelAttribute("adminlogin") AdminLogin adminlogin) {

		return "AdminLogin";
	}

	@RequestMapping(value = "/adminloginentry", method = RequestMethod.POST)
	public String LoginPost(@ModelAttribute("adminlogin") AdminLogin adminlogin, ModelMap model, BindingResult result) {
		TicketService tk = new TicketService();
		String str = tk.AdminLoginCheck(adminlogin);
		List result1 = jdbc.queryForList(str);
		// System.out.println("result1" + result1);
		if (adminlogin.getUsername().isEmpty()) {
			model.put("user", "Enter the user id");

		}
		if (adminlogin.getPassword().isEmpty()) {
			model.put("pass", "Enter the Password");
		}
		if (result1.isEmpty()) {
			model.put("error", "Admin Not Exist");
			return "AdminLogin";
		} else {
			model.put("msg", "Admin");
			return "sucessful";
		}

	}

	/*
	 * @RequestMapping("/insert") public String index(){
	 * jdbc.execute("insert into user(name,email)values('siqique','kjjkk')");
	 * return "data inserted Successfully"; }
	 * 
	 * @RequestMapping("/update") public List display(){ //ResultSet
	 * rs=stmt.executeQuery("select * from emp"); String query =
	 * "SELECT * FROM user"; System.out.println("hbjygf"+jdbc); List results =
	 * jdbc.queryForList(query); System.out.println(results); return results;
	 */

}
