<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>confirmation</title>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="stylesheet"
	href="//netdna.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
<link rel="stylesheet"
	href="//netdna.bootstrapcdn.com/font-awesome/3.2.1/css/font-awesome.min.css">
<link rel="stylesheet" href="css/login.css">
<link rel="stylesheet" href="css/homepage.css">
<link rel="stylesheet" href="css/approval.css">
<script>
	function continueWork(pName) {
		window.location = "Continue?pName=" + pName;
	}
</script>
</head>
<body style="background-image: url('images/registration.jpg')">
	<jsp:include page="menu.jsp"></jsp:include>
	<div>
		<center>
			<div>
				<img src="images/header.jpg" height="120" width="560">
			</div>
		</center>
	</div>
	<form>
		<div class="well">
			<center>
				<h3>The Patient details</h3>
			</center>
		</div>
		<div class="well">
			<table>
				<tbody>
					<tr>
						<th style="width: 300px">NAME</th>
						<th style="width: 300px">CONTACT</th>
						<th style="width: 300px">AMOUNT</th>
						<th style="width: 300px">CLAIM</th>
						<th style="width: 300px">BALANCE</th>
				</tbody>
			</table>
		</div>
		<div class="well">
			<table>
				<tbody>
					</tr>
					<tr>
						<td style="width: 250px"><c:out
								value="${updatepatient.getName()}"></c:out></td>
						<td style="width: 270px"><c:out
								value="${updatepatient.getContact()}"></c:out></td>
						<td style="width: 270px"><c:out
								value="${updatepatient.getAmount()}"></c:out></td>
						<td style="width: 270px"><c:out
								value="${updatepatient.getClaim()}"></c:out></td>
						<td style=""><c:out value="${updatepatient.getBalance()}"></c:out>
						</td>
					</tr>
				</tbody>
			</table>
		</div>
	</form>
	<div>
		<input class="approve" type="button" value="Continue"
			onclick="continueWork('<c:out value="${updatepatient.getName()}"></c:out>')">
	</div>
</body>
</html>