package com.model;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.stereotype.Component;

public class Ticket {
	@NotNull
	private String gender;
	@NotNull
	private String dob;
	@NotNull
	private String cpassword;
	@Size(min=2, max=30)
	@NotNull
	private String firstName;
	@NotNull
	private String Contact;
	@Size(min=2, max=30)
	private String lastName;
	@NotNull
	private String Email;
	@NotNull
	private String password;

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getCpassword() {
		return cpassword;
	}

	public void setCpassword(String cpassword) {
		this.cpassword = cpassword;
	}

	public String getDob() {
		return dob;
	}

	public void setDob(String dob) {
		this.dob = dob;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getContact() {
		return Contact;
	}

	public void setContact(String contact) {
		Contact = contact;
	}

	public String getEmail() {
		return Email;
	}

	public void setEmail(String email) {
		Email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	
	@Override
	public String toString() {
		return "Ticket [gender=" + gender + ", dob=" + dob + ", cpassword=" + cpassword + ", firstName=" + firstName
				+ ", Contact=" + Contact + ", lastName=" + lastName + ", Email=" + Email + ", password=" + password
				+ "]";
	}

}
