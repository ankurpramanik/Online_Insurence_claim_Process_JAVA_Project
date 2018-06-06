<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<
<html>
<head>
<title>Login</title>
<meta charset="UTF-8">
<meta name="viewport" content="w idth=device-width, initial-scale=1.0">
<link rel="stylesheet"
	href="//netdna.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
<link rel="stylesheet"
	href="//netdna.bootstrapcdn.com/font-awesome/3.2.1/css/font-awesome.min.css">
<link rel="stylesheet" href="css/login.css">
</head>
<body style="background-image: url('images/home.jpg')">
	<div class="container">
		<div class="wrapper">
			<form action="LoginServlet" method="post" class="form-signin">
				<h3 class="form-signin-heading">Please Login</h3>
				<hr class="colorgraph">
				<br>
				<!--                    <error message to be displayed here>-->
				<label class="alert-danger"> <c:out
						value="${myErrorMsg.getErrorMessage()}"></c:out>
				</label> <input type="text" class="form-control" name="username"
					id="username" placeholder="Username" required autofocus="" /> <input
					type="password" class="form-control" name="password" id="password"
					placeholder="Password" required />

				<button class="btn btn-primary" name="Submit" value="Login"
					type="Submit">Login</button>
				<br> <br> <label>Don't have account?</label><a
					href="registeruser.jsp">Register now</a>
			</form>
		</div>
	</div>
</body>
</html>