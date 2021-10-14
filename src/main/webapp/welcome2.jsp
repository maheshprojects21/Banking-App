<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<link href="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
<script src="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
<script src="//code.jquery.com/jquery-1.11.1.min.js"></script>

<link rel="stylesheet" href="mystyle.css">


</head>
<body>

					<%
							String status = (String) request.getSession().getAttribute("status");
							if (status.equals("Failed to Withdraw")) {
								out.print("<script>alert('Cannot withdraw amount greater than the current balance!')</script>");
							
							} else if(status.equals("Failed to transfer")) {
								out.print("<script>alert('Unknown account id and / or incorrect transfer!')</script>");
							}
							else {
								response.sendRedirect("welcome.jsp");
							}
						%>

</body>
</html>