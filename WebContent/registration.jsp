<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Regitration</title>
<link rel="stylesheet" href="css/registration.css">
<link
	href="//maxcdn.bootstrapcdn.com/bootstrap/3.3.0/css/bootstrap.min.css"
	rel="stylesheet" id="bootstrap-css">
</head>
<body style="background-image: url('images/registration.jpg')">
	<jsp:include page="menu.jsp"></jsp:include>
	<div class="container">
		<h1 class="well">Registration Form</h1>
		<div class="col-lg-12 well">
			<div class="row">
				<form action="RegistrationServlets" method="post">
					<div class="col-sm-12">
						<div class="row">
							<div class="col-sm-6 form-group">
								<label>Smart card no.:</label> <input required="" type="text"
									placeholder="Enter smart card no here..." class="form-control"
									name="smartcard">
							</div>

						</div>
						<div class="form-group">
							<label>Name</label> <input placeholder="Enter name here..."
								rows="3" class="form-control" name="name" required="">
						</div>
						<div class="row">
							<div class="col-sm-4 form-group">
								<label>Contact no</label> <input type="number"
									placeholder="Enter Contact no Here..." class="form-control"
									name="contact" required="">
							</div>
							<div class="col-sm-4 form-group">
								<label>Amount</label> <input type="number"
									placeholder="Enter amount Here.." class="form-control"
									name="amount" disabled="">
							</div>
							<div class="col-sm-4 form-group">
								<label>Claim</label> <input type="number"
									placeholder="Enter claim Here.." class="form-control"
									name="claim" disabled="">
							</div>
						</div>
						<div class="row">
							<div class="col-sm-6 form-group">
								<label>Balance</label> <input type="number"
									placeholder="Enter balance Here.." class="form-control"
									name="balance" disabled="">
							</div>
							<div class="col-sm-6 form-group">
								<label>Email</label> <input required="" type="email"
									placeholder="Enter email Here.." class="form-control"
									name="email">
							</div>
						</div>
						<input type="submit" value="Submit" class="btn-primary">
					</div>
				</form>
			</div>
		</div>
	</div>
</body>
</html>