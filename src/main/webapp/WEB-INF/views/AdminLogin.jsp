<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<html>
<head>
<link
	href="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css"
	rel="stylesheet" id="bootstrap-css">
<script
	src="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js"></script>
<script
	src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<!------ Include the above in your HEAD tag ---------->

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>

<style>
body {
	margin: 0;
	padding: 0;
	background-color: #17a2b8;
	height: 100vh;
}

*[role="form"] {
	max-width: 451px;
	padding: 15px;
	margin: 0 auto;
	border-radius: 0.3em;
	background-color: #f2f2f2;
}
/* #login .container #login-row #login-column #login-box {
  margin-top: 120px;
  max-width: 600px;
  height: 320px;
  border: 1px solid #9C9C9C;
  background-color: #EAEAEA;
} */
#login .container #login-row #login-column #login-box #login-form {
	padding: 20px;
}

#login .container #login-row #login-column #login-box #login-form #register-link
	{
	margin-top: -85px;
}
</style>


</head>
<body>
	<div id="login">
		<h3 class="text-center text-white pt-5">Grocerry Shopping</h3>

		<div class="container">
			<div id="login-row"
				class="row justify-content-center align-items-center">
				<div id="login-column" class="col-md-6">
					<div id="login-box" class="col-md-12" role="form">
						<form:form id="login-form" class="form" method="POST"
							action="/adminloginentry" modelAttribute="adminlogin">
							<h3 class="text-center text-info">Admin Login</h3>
							<div class="form-group">
								<sf:label for="username" class="text-info" path="username">Username:</sf:label>
								<br>
								<div>
									<sf:input type="text" name="username" path="username"
										id="username" class="form-control" placeholder="Enter the UserId"/>
								</div>
								<p style="color: red">${user}</p>
							</div>

							<div class="form-group">
								<sf:label for="password" path="password" class="text-info">Password:</sf:label>
								<br>
								<div>
									<sf:input type="text" path="password" placeholder="Enter the Password"
										name="password" id="password" class="form-control" />
								</div>
								<p style="color: red">${pass}</p>

							</div>
							<div class="form-group">
								<label for="remember-me" class="text-info"><span>Remember
										me</span> <span><input id="remember-me" name="remember-me"
										type="checkbox"></span></label><br> <input type="submit"
									name="submit" class="btn btn-info btn-md" value="submit">
							</div>
							<div id="register-link" class="text-right">
								<a href="userdata" class="text-info">Register here</a><br>
								<p style="color: red">${error}</p>
							</div>
							
						</form:form>
						
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>