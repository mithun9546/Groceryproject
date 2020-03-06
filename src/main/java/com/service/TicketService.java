package com.service;

import org.springframework.stereotype.Service;

import com.model.AdminLogin;
import com.model.Login;
import com.model.User;;
@Service
public class TicketService {
	
	public String insert(User user){
		
		String fname = user.getFirstName();
		String lname = user.getLastName();
		String pass = user.getCpassword();
		String email = user.getEmail();
		String contact = user.getContact();
		String dob = user.getDob();
		String str = "insert into register(firstname,lastname,password,email,contact,dob) values('"+fname+"','"+lname+"','"+pass+"','"+email+"','"+contact+"','"+dob+"')";
		return str;
	}
	public String check(User user){
		String email = user.getEmail();
		String str = "select * from register where email ='"+email+"'";
		return str;
		
	}
	
	
	
	public String loginCheck(Login login){
		
		String email = login.getLemail();
		String passw = login.getLpassword();
		//System.out.println("email"+ email);
		//System.out.println("password" + passw);
		String qry = "select * from register where email ='"+email+"' and password = '"+passw+"'";
		
		return qry;
	}

public String AdminLoginCheck(AdminLogin login){
		
		String username = login.getUsername();
		String passw = login.getPassword();
		//System.out.println("email"+ username);
		//System.out.println("password" + passw);
		String qry = "select * from admin where usaername ='"+username+"' and password = '"+passw+"'";
		
		return qry;
	}

}
	 	  	    	    	     	      	 	

