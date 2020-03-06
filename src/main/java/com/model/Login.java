package com.model;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.springframework.stereotype.Component;


public class Login {
	
	private String Lemail;
	private String Lpassword;

	public String getLemail() {
		return Lemail;
	}

	public void setLemail(String lemail) {
		Lemail = lemail;
	}

	public String getLpassword() {
		return Lpassword;
	}

	public void setLpassword(String lpassword) {
		Lpassword = lpassword;
	}
	
	

}
