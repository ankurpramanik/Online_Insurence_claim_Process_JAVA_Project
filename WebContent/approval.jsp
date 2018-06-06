<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Approve</title>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="stylesheet"
	href="//netdna.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
<link rel="stylesheet"
	href="//netdna.bootstrapcdn.com/font-awesome/3.2.1/css/font-awesome.min.css">
<link rel="stylesheet" href="css/login.css">
<link rel="stylesheet" href="css/approval.css">
<script>
        function approve(pId, pName)
        {
            window.location = "Approve?pId=" + pId + "&pName=" + pName;
        }
        function disagree()
        {
            window.location = "HomeServlet";
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
	<form name="myForm">
		<div class="well">
			<table>
				<tbody>
					<tr>
						<th style="width: 300px">CODE</th>
						<th style="width: 300px">DESCRIPTION</th>
						<th style="width: 300px">AMOUNT</th>
					</tr>
				</tbody>
			</table>
		</div>
		<div class="well">
			<table>
				<tbody>
					<tr>
						<td style="width: 300px"><c:out
								value="${mydescription.getDescription_id()}">

							</c:out></td>
						<td style="width: 300px"><c:out
								value="${mydescription.getDescription_name()}">

							</c:out></td>
						<td style="width: 300px"><c:out
								value="${mydescription.getDescription_amount()}">

							</c:out></td>
					</tr>
				</tbody>
			</table>
		</div>
		<div class="well">
			<center>
				<input class="approve" type="button" value="Approve"
					onclick="approve(<c:out value="${mydescription.getDescription_id()}"></c:out>, '<c:out value="${patientname.getPatientName()}"></c:out>')">
				<input type="button" value="Disagree" class="approve"
					onclick="disagree()">
			</center>
		</div>
		</tbody>
	</form>
</body>

</html>