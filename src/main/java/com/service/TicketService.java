package com.service;

import org.springframework.stereotype.Service;

import com.model.Login;
import com.model.Ticket;;
@Service
public class TicketService {
	
	public String insert(Ticket ticket){
		
		String fname = ticket.getFirstName();
		String lname = ticket.getLastName();
		String pass = ticket.getCpassword();
		String email = ticket.getEmail();
		String contact = ticket.getContact();
		String dob = ticket.getDob();
		String str = "insert into register(firstname,lastname,password,email,contact,dob) values('"+fname+"','"+lname+"','"+pass+"','"+email+"','"+contact+"','"+dob+"')";
		return str;
	}
	public String check(Ticket ticket){
		String email = ticket.getEmail();
		String str = "select * from register where email ='"+email+"'";
		return str;
		
	}
	
	
	
	public String loginCheck(Login login){
		
		String email = login.getLemail();
		String passw = login.getLpassword();
		System.out.println("email"+ email);
		System.out.println("password" + passw);
		String qry = "select * from register where email ='"+email+"' and password = '"+passw+"'";
		
		return qry;
	}

}
	 	  	    	    	     	      	 	

