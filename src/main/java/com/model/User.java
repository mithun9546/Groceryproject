package com.model;

/*import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.stereotype.Component;*/
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.springframework.stereotype.Component;
@Component
public class User {
	@NotEmpty(message = "Gender is required")
	private String gender;
	@NotEmpty(message = "Dob  is required")
	private String dob;
	
	private String cpassword;
	
	@NotEmpty(message = "First Name is required")
	private String firstName;
	@NotEmpty(message = "Phone Number is required")
	@Pattern(regexp = "^\\(?(\\d{3})\\)?[- ]?(\\d{3})[- ]?(\\d{4})$", message = "Mobile number is invalid")
	private String Contact;
	@NotEmpty(message = "Last Name is required")
	private String lastName;
	@NotEmpty(message = "Email is required")
	@Email
	private String Email;
	@NotEmpty(message="Password not be less than 8 character")
	@Size(min = 8, max = 64)
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
