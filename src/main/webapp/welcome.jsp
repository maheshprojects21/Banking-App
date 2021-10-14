<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Your account</title>

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
	
	if (session.getAttribute("isVerified") == null) {
		response.sendRedirect("signin.jsp");
	}
	
/* 	if (request.getAttribute("incorrectUsernamePwd") == "true") {
		out.print("<script>alert('Incorrect username and/or password!')</script>");
	} */

%>
	<div class="sidenav">
         <div class="login-main-text">
            <h2>Hello, ${firstName} ${lastName}!<br></h2>
            <p><h4>Your account details are:</h4></p>
            
           
			<div class="form-group">
				<h5>Account ID: ${accountId}</h5>			
			</div> 
			            
            <div class="form-group">
				<h5>First Name: ${firstName}</h5>		
			</div>	
			
			 <div class="form-group">
				<h5>Last Name: ${lastName}</h5>		
			</div>
			
			<div class="form-group">
				<h5>Email ID: ${emailId}	</h5>		
			</div>
		
			
			<div class="form-group">
				<h5>Current balance: $${balance}	</h5>		
			</div>
			
			<div class="form-group">
	       		<form action="<%=request.getContextPath()%>/Logout" method="post" id="logout">
					<button type="submit" class="btn btn-red">Logout</button>
				</form>							
			</div>
			
			
			<div class="form-group">
	       		<form action="<%=request.getContextPath()%>/Delete" method="post" id="delete">
					<button type="submit" class="btn btn-close-account">Close Your Account</button>
				</form>							
			</div>			
			
			
         </div>
      </div>
      
      <div class="main">
         <div class="col-md-6 col-sm-12">
            <div class="login-form3">
               
               
                		<div class="form-group">
  		            		<form action="http://localhost:8080/banking-app/deposit.jsp" method="post" id="deposit">
								<button type="submit" class="btn btn-black">Deposit</button>
							</form>
						</div>
						
						<div class="form-group">
  		            		<form action="http://localhost:8080/banking-app/withdraw.jsp" method="post" id="withdraw">
								<button type="submit" class="btn btn-black">Withdraw</button>
							</form>							
						</div>
					
						
						<div class="form-group">
  		            		<form action="http://localhost:8080/banking-app/transfer.jsp" method="post" id="transfer">
								<button type="submit" class="btn btn-black">Transfer</button>
							</form>							
						</div>
                  
                  
            </div>
         </div>
      </div>
      
      
      
</body>
</html>