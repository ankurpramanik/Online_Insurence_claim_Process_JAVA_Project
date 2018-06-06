<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Home Page</title>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="stylesheet"
	href="//netdna.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
<link rel="stylesheet"
	href="//netdna.bootstrapcdn.com/font-awesome/3.2.1/css/font-awesome.min.css">
<link rel="stylesheet" href="css/login.css">
<link rel="stylesheet" href="css/homepage.css">
<script>
	
</script>
</head>
<body style="background-image: url('images/home.jpg')">
	<jsp:include page="menu.jsp"></jsp:include>
	<div>
		<center>
			<div>
				<img src="images/header.jpg" height="120" width="560">
			</div>
		</center>
	</div>
	<c:if test="${getAnswer.isResult()}">
		<form action="PatientServlet" method="post">

			<div class="search">
				<table>
					<tbody>
						<label> <c:out value="${myError.getErrormessage()}"></c:out>
						</label>
						<tr>
							<td><label> Enter Smart Card Number:</label></td>

							<td><input type="text" name="smartcard"></td>

							<td><input type="submit" value="GO" class="btn-primary">
							</td>
						</tr>
					<tbody>
				</table>
			</div>
		</form>
	</c:if>
	<c:if test="${myAnswerr.isResult()}">
		<form action="AmountServlet" method="post">
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
							<td style="width: 250px"><c:out value="${patient.getName()}"></c:out>
							</td>
							<td style="width: 270px"><c:out
									value="${patient.getContact()}"></c:out></td>
							<td style="width: 270px"><c:out
									value="${patient.getAmount()}"></c:out></td>
							<td style="width: 270px"><c:out
									value="${patient.getClaim()}"></c:out></td>
							<td style=""><c:out value="${patient.getBalance()}"></c:out>
							</td>
						</tr>
					</tbody>
				</table>
			</div>

			<div class="search">
				<table>
					<tbody>
						<tr>
							<td><label>Enter procedure code:</label></td>
							<td><select name="description">
									<option value="0">
                                            --select a code--
                                        </option>
									<c:forEach items="${mydescription_id}" var="description">
										<option
											value="<c:out value="${description.getDescription_id()}"></c:out>">
                                            <c:out value="${description.getDescription_name()}"></c:out>
                                            </option>
									</c:forEach>
							</select></td>
						</tr>
						<tr>
							<td><input type="submit" value="Submit" class="btn-primary">
							</td>
						</tr>
				</table>
				</tbody>
			</div>
			<input type="hidden" name="patientName"
				value="<c:out value="${patient.getName()}"></c:out>">
		</form>
	</c:if>
</body>
</html>