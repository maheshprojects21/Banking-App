<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login to your account</title>

<link href="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
<script src="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
<script src="//code.jquery.com/jquery-1.11.1.min.js"></script>

<link rel="stylesheet" href="mystyle.css">

</head>
<body>
<%

	response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate"); // HTTP 1.1
	
	response.setHeader("Pragma", "no-cache"); // HTTP 1.0
	
	response.setHeader("Expires", "0"); // Proxy server
	
	if (session.getAttribute("isVerified") != null) {
		response.sendRedirect("welcome.jsp");
	}

%>

	<div class="sidenav">
         <div class="login-main-text">
            <h2>Application<br> Login to your account</h2>
            <p>Sign in to your account</p>
         </div>
      </div>
      
      <div class="main">
         <div class="col-md-6 col-sm-12">
            <div class="login-form1">
               <form class="well form-horizontal" action="<%=request.getContextPath()%>/AccountServlet"
						method="post" id="login">
						
						
				 	<div class="form-group">
						<label class="control-label">Email ID</label> 
						<input type="text" class="form-control"
							name="emailId" placeholder="Email ID">
					</div>
					
					
					<div class="form-group">
						<label>Password</label> <input type="password"
							class="form-control" name="password" placeholder="Password">
					</div>              
              		
              		<div>
						<button type="submit" class="btn btn-primary">Login</button>
					</div>
               </form>
            </div>
         </div>
      </div>
	
     



</body>
</html>