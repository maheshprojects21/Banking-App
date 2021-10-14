<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Withdraw</title>

<link href="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
<script src="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
<script src="//code.jquery.com/jquery-1.11.1.min.js"></script>

<link rel="stylesheet" href="mystyle.css">
<script type="text/javascript">
	function checkBal() {

		var b = document.getElementById("balance").innerHTML;
		var a = document.getElementById("withdrawAmount").value;

		if ((b - a) < 0) {
			alert("Insufficient Balance");
			return false;
		}
	}
</script>
</head>
<body>

<%

/* 	response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate"); // HTTP 1.1
	
	response.setHeader("Pragma", "no-cache"); // HTTP 1.0
	
	response.setHeader("Expires", "0"); // Proxy server */
	
	if (session.getAttribute("isVerified") == null) {
		response.sendRedirect("signin.jsp");
	}

%>

   <div class="sidenav">
         <div class="login-main-text">
            <h3>Deposit amount to your own account</h3>
            <p><h4>Your account details are:</h4></p>
            
           
			<div class="form-group">
				<h5>AccountId: ${accountId}</h5>			
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
				<h5>Current balance: ${balance}	</h5>		
			</div>
			
			<div class="form-group">
	       		<form action="<%=request.getContextPath()%>/Logout" method="post" id="logout">
					<button type="submit" class="btn btn-red">Logout</button>
				</form>							
			</div>
			
			
         </div>
      </div>
      
      <div class="main">
         <div class="col-md-6 col-sm-12">
            <div class="login-form2">
               <form class="well form-horizontal" action="<%=request.getContextPath()%>/Withdraw"
						method="post" id="withdraw" onsubmit="return checkBal();">
               
               
                		<div class="form-group">
							<label class="control-label">Withdraw Amount</label> 
							<input type="text" class="form-control"
								name="withdrawAmount" placeholder="Withdraw amount in USD">
								You cannot withdraw more than the current balance in your account.
						</div>
						
            <div class="form-group">
					<button type="submit" class="btn btn-black">Withdraw</button>
			</div>					
					
						
               </form>
            </div>
            
           	<div class="form-group">
 		  		<form action="http://localhost:8080/banking-app/welcome.jsp">
					<button type="submit" class="btn btn-primary">Home</button>
				</form>							
			</div>
			
         </div>
      </div>     
      
   

</body>
</html>