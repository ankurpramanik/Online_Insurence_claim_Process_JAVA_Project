<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Log in</title>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="stylesheet"
	href="//netdna.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
<link rel="stylesheet"
	href="//netdna.bootstrapcdn.com/font-awesome/3.2.1/css/font-awesome.min.css">
<link rel="stylesheet" href="css/login.css">
<link rel="stylesheet" href="css/approval.css">

<script>
	function proceed() {
		//            alert("Empid="+empId);
		window.location = "HomeServlet";
	}

	function logout() {

		window.location = "Logout";

	}
</script>
</head>
<body style="background-image: url('images/registration.jpg')">
	<div class="wrapper">
		<center>
			<div>
				<img src="images/header.jpg" height="120" width="560"><br>
				<br>
			</div>
			<div class="well">
				<center>
					<h3>
						A assurance mail is to be sent to:
						<c:out value="${patientemail.getEmail()}"></c:out>
					</h3>
				</center>
			</div>
		</center>
	</div>

	<div class="well">
		<center>

			<input type="button" value="Proceed" class="approve"
				onclick="proceed()"> <input type="button" value="Logout"
				class="approve" onclick="logout()">
		</center>
	</div>
</body>
</html>