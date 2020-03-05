<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<body style="background-color:lavender">
<h1><center> User Resgistration Form</center></h1>
<h2 style = "color:red"> <center>${Error}</center></h2>
<center><form:form method="POST" action="/calculateCost" modelAttribute="ticket">


              <table>
              <tr>
              	<td><sf:label path="firstName">First Name</sf:label></td>
              	<td><sf:input path="firstName" id="firstName" placeholder="Enter first name" required = "required"/></td>
              
              </tr><tr>
              	<td><sf:label path="lastName">Last  Name</sf:label></td>
              	<td><sf:input path="lastName" id="lastName" placeholder="Enter last name"/></td>
              
              </tr>
             <tr>
              	<td><sf:label path="dob">Date Of Birth</sf:label></td>
              	<td><sf:input type = "date" path="dob" id="dob" /></td>
              
              </tr>
              <tr>
              	<td>Gender</td>
              	<td><input type = "radio" name="gender"  path="gender" value = "male"/>Male
              		<input type = "radio"  name="gender"   path="gender" value = "Female"/>Female</td>
              
              </tr>
              

              	

			
			<tr>
				<td><sf:label path="Contact">Contact Number</sf:label></td>
				<td><sf:input type = "tel" path ="Contact" id="Contact" placeholder = "Enter your Contact"/></td>
			</tr>
			<tr>
				<td><sf:label path="Email">EmailId</sf:label></td>
				<td><sf:input type = "email"  path ="Email" id="Email" placeholder="Enter Email"/></td>
			</tr>
			<tr>
              	<td><sf:label path="password">Password</sf:label></td>
              	<td><sf:input type = "password" path="password" id="password" placeholder="Enter password"/></td>
              
              </tr>
              <tr>
              	<td><sf:label path="cpassword">Confirm Password</sf:label></td>
              	<td><sf:input type = "password" path="cpassword" id="cpassword" placeholder="Enter Confirm password"/></td>
              	      
               <td><p style = "color:red"> ${passerror} </p></td>
      </tr>
			
			
			<tr>
				<td><input type="submit" value="Submit" id="submit"
					name="submit"></td>
				
			</tr>
		</table>
	
</form:form></center>


</body>
</html>	 