package com.controller;
import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import com.service.TicketService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.model.Login;
import com.model.Ticket;
@Controller
public class TicketController {
	
	@Autowired
	private TicketService ticketService;
	 @Autowired
	 JdbcTemplate jdbc; 
	
	 
	 
	 
	 
	@RequestMapping(value="/showpage",method=RequestMethod.GET)
	public String showPage(@ModelAttribute("ticket") Ticket ticket){
	ticket=new Ticket();
		return "showpage";
	}
	
	
	@RequestMapping(value="/calculateCost",method=RequestMethod.POST)
	public String calculateTotalCost(@ModelAttribute("ticket") Ticket ticket,ModelMap model,BindingResult result) {

		if(!ticket.getCpassword().equals(ticket.getPassword())){
			model.put("passerror", "password do not match!");
			return "showpage";
		}else{
		TicketService tk = new TicketService();
		String error = tk.check(ticket);
		List result1 = jdbc.queryForList(error);
		//System.out.println("result " + result1);
		if(!result1.isEmpty()){
			model.put("Error", "User Already Exist!!!");
			 return "showpage";	
			}else{
				String str = tk.insert(ticket);
				jdbc.execute(str);
			return "Mainpage";
			}
		
		
		}
	}
	
		
	@RequestMapping(value="/login",method=RequestMethod.GET)
	public String showLoginPage(@ModelAttribute("login") Login login){

		return "result";
	}
	@RequestMapping(value="/loginentry",method=RequestMethod.POST)
	public String LoginPost(@ModelAttribute("login") Login login,ModelMap model,BindingResult result) {

		TicketService tk = new TicketService();
		String str = tk.loginCheck(login);
		List result1 = jdbc.queryForList(str);
		System.out.println("result1" + result1);
		if(result1.isEmpty()){
			model.put("error","Wrong Credential!!");
			return "result";
		}else{
		 return "Mainpage";	
		}
		
		
		
		
		
	}
	
	
	
	
	
	
	
	
	
	 /*    
	    @RequestMapping("/insert")
	    public String index(){  
	        jdbc.execute("insert into user(name,email)values('siqique','kjjkk')");
	        return "data inserted Successfully";
	    }  
	    @RequestMapping("/update")
	    public List display(){
	    	//ResultSet rs=stmt.executeQuery("select * from emp"); 
	    	 String query = "SELECT * FROM user";
	    	 System.out.println("hbjygf"+jdbc);
	         List results = jdbc.queryForList(query);
	         System.out.println(results);
	    	return results;*/
	
	
	
	
	
	
	
	
	
	
	
	

}
