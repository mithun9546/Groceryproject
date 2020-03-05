<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<body style="background-color:lavender">
<h1><center> Login Form</center></h1>
<h2 style = "color:red"> <center>${Error}</center></h2>
<center><form:form method="POST" action="/loginentry" modelAttribute="login">

           
              <table>
			<tr>
				<td><sf:label path="Lemail">EmailId</sf:label></td>
				<td><sf:input type = "email"  path ="Lemail" id="Lemail" placeholder="Enter Email"/></td>
			</tr>
			<tr>
              	<td><sf:label path="Lpassword">Password</sf:label></td>
              	<td><sf:input type = "password" path="Lpassword" id="Lpassword" placeholder="Enter password"/></td>
              
              </tr>
             
			<tr>
				<td><input type="submit" value="Login" id="submit"
					name="submit"></td><!--
					<td><input type="submit" value="Register" id="register"
					name="submit"></td> -->
					<td><sf:button><a href = "/showpage"> Register</a></sf:button> </td>
			</tr>
		</table>
	   <p style = "color:red"> ${error} </p>
</form:form></center>


</body>
</html>	 