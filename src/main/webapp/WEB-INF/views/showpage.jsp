<!DOCTYPE html>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<html lang="en">
<head>

<style>
.form-horizontal{
  background-color: #EAEAEA;}
  .col-sm-3 control-label{
  background-color: #EAEAEA;
  }
  </style>

	<!-- Access the bootstrap Css like this, 
		Spring boot will handle the resource mapping automcatically -->
	<link rel="stylesheet" type="text/css" href="webjars/bootstrap/3.3.7/css/bootstrap.min.css" />

	<!-- 
	<spring:url value="/css/main.css" var="springCss" />
	<link href="${springCss}" rel="stylesheet" />
	 -->
	<c:url value="/css/main.css" var="jstlCss" />
	<link href="${jstlCss}" rel="stylesheet" />
	
	<link href="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
<script src="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
<script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<!------ Include the above in your HEAD tag ---------->

<link href="//netdna.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
<script src="//netdna.bootstrapcdn.com/bootstrap/3.2.0/js/bootstrap.min.js"></script>
<script src="//code.jquery.com/jquery-2.1.3.min.js"></script>
<!------ Include the above in your HEAD tag ---------->
</head>
<body>



	<!-- <nav class="navbar navbar-inverse">
		<div class="container">
			<div class="navbar-header">
				<a class="navbar-brand" href="#">Grocery Management</a>
			</div>
			<div id="navbar" class="collapse navbar-collapse">
				<ul class="nav navbar-nav">
					<li class="active"><a href="#">Home</a></li>
					<li><a href="#about">About</a></li>
					<li><a href="#about">Help</a></li>
					<li><a href="#about">Logout</a></li>
				</ul>
			</div>
		</div>
	</nav> -->
	<nav class="navbar navbar-inverse">
  <div class="container-fluid">
    <div class="navbar-header">
      <a class="navbar-brand" href="/home">Grocerry Shopping</a>
    </div>
    <div class="navbar-header">
      <a class="navbar-brand" href="/login">Login</a>
    </div>
    <ul class="nav navbar-nav">
      <li class="active"><a href="#">Home</a></li>
    </ul>
    <form class="navbar-form navbar-left" action="#">
      <div class="input-group">
        <input type="text" class="form-control" placeholder="Search" name="search">
        <div class="input-group-btn">
          <button class="btn btn-default" type="submit">
            <i class="glyphicon glyphicon-search"></i>
          </button>
        </div>
      </div>
    </form>
     <div class="navbar-header">
      <a class="navbar-brand" href="/adminlogin">Admin Login</a>
    </div>
  </div>
</nav>




<div class="container">
            <form:form class="form-horizontal" role="form"  method="POST" action="/userdata" modelAttribute="user" >
                <h2>Registration</h2>
				<h2 style = "color:red"> <center>${Error}</center></h2>
                <div class="form-group">
                    <sf:label for="firstName" path="firstName" class="col-sm-3 control-label">First Name</sf:label>
                    <div class="col-sm-9">
                        <sf:input type="text" path="firstName" id="firstName" placeholder="First Name" class="form-control"  />
                     <form:errors path="firstName" cssStyle="color: #ff0000;"/>
                    </div>
                </div>
                <div class="form-group">
                    <sf:label for="lastName" path="lastName" class="col-sm-3 control-label">Last Name</sf:label>
                    <div class="col-sm-9">
                        <sf:input type="text" id="lastName" path="lastName" placeholder="Last Name" class="form-control"  />
                    <form:errors path="lastName" cssStyle="color: #ff0000;"/>
                    </div>
                </div>
				 <div class="form-group">
                    <sf:label for="birthDate" path="dob" class="col-sm-3 control-label">Date of Birth*</sf:label>
                    <div class="col-sm-9">
                        <sf:input type="date" path="dob" id="birthDate" class="form-control" />
                   <form:errors path="dob" cssStyle="color: #ff0000;"/>
                    </div>
                </div>
                   <div class="form-group">
                    <sf:label class="control-label col-sm-3" path="gender">Gender</sf:label>
                   <div class="col-sm-9">
                        
                         <sf:radiobuttons  path="gender" items="${radio }" />
                          <form:errors path="gender" cssStyle="color: #ff0000;"/>

                </div>
                </div>
				  <div class="form-group">
                    <sf:label for="phoneNumber" path="Contact" class="col-sm-3 control-label">Phone number </sf:label>
                    <div class="col-sm-9">
                        <sf:input type="phoneNumber" id="phoneNumber" path="Contact" placeholder="Phone number" class="form-control" />
                        <span class="help-block">Your phone number won't be disclosed anywhere </span>
                     <form:errors path="Contact" cssStyle="color: #ff0000;"/>
                    </div>
                </div>
                <div class="form-group">
                    <sf:label for="email" path="Email"  class="col-sm-3 control-label">Email* </sf:label>
                    <div class="col-sm-9">
                        <sf:input type="email" id="email" path="Email"  placeholder="Email" class="form-control" name= "email" />
                     <form:errors path="Email" cssStyle="color: #ff0000;"/>
                    </div>
                </div>
               
                <div class="form-group">
                    <sf:label for="password" path="password" class="col-sm-3 control-label">Password*</sf:label>
                    <div class="col-sm-9">
                        <sf:input type="password" path="password" id="password" placeholder="Password" class="form-control" />
                    <form:errors path="password" cssStyle="color: #ff0000;"/>
                    </div>
                </div>
                <div class="form-group">
                    <sf:label for="password" path="cpassword" class="col-sm-3 control-label">Confirm Password*</sf:label>
                    <div class="col-sm-9">
                        <sf:input type="password"  path="cpassword" id="password" placeholder="Password" class="form-control" />
						<p style = "color:red"> ${passerror} </p>
						 <form:errors path="cpassword" cssStyle="color: #ff0000;"/>
                    </div>
                </div>
             
               <!-- /.form-group -->
                <div class="form-group">
                    <div class="col-sm-9 col-sm-offset-3">
                        <span class="help-block">*Required fields</span>
                    </div>
                </div>
                <button type="submit" class="btn btn-primary btn-block">Register</button>
            </form:form> 
            <!-- /form -->
        </div> <!-- ./container -->
</body>
</html>