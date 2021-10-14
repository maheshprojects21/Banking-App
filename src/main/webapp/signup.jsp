<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Open an account</title>

<link href="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
<script src="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
<script src="//code.jquery.com/jquery-1.11.1.min.js"></script>



<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">

<!-- jQuery library -->
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>

<!-- Latest compiled JavaScript -->
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>


<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
<script
	src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
<script
	src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>
<script
	src="https://ajax.googleapis.com/ajax/libs/angularjs/1.6.4/angular.min.js"></script>

<!-- Latest compiled JavaScript -->
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<link rel="stylesheet"
	href="//cdnjs.cloudflare.com/ajax/libs/jquery.bootstrapvalidator/0.5.2/css/bootstrapValidator.min.css" />
<script type="text/javascript"
	src="//cdnjs.cloudflare.com/ajax/libs/jquery.bootstrapvalidator/0.5.2/js/bootstrapValidator.min.js"></script>


<link rel="stylesheet"
	href="//cdnjs.cloudflare.com/ajax/libs/jquery.bootstrapvalidator/0.5.2/css/bootstrapValidator.min.css" />
<script type="text/javascript"
	src="//cdnjs.cloudflare.com/ajax/libs/jquery.bootstrapvalidator/0.5.2/js/bootstrapValidator.min.js"></script>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css" />
<link rel="stylesheet" href="mystyle.css">
</head>
<body>

	<div class="sidenav">
         <div class="login-main-text">
            <h2>Application<br> Create an account</h2>
            <p>Open your bank account here</p>
         </div>
      </div>
      
      
      <div class="main">
         <div class="col-md-6 col-sm-12">
            <div class="login-form2">
               <form class="well form-horizontal" action="<%=request.getContextPath()%>/CreateAccount"
						method="post" id="signup">
               
               
                		<div class="form-group">
							<label class="control-label">First Name</label> 
							<input type="text" class="form-control"
								name="firstName" placeholder="First Name">
						</div>
						
						<div class="form-group">
							<label class="control-label">Last Name</label> 
							<input type="text" class="form-control"
								name="lastName" placeholder="Last Name">
						</div>
						
						
						<div class="form-group">
							<label class="control-label">Email id</label> 
							<input type="text" class="form-control"
								name="emailId" placeholder="Email Id">
						</div>
						
						<div class="form-group">
							<label>Password</label> 
							<input type="password" class="form-control" name="password" placeholder="Password">
						</div>
						
						<div class="form-group">
							<label>Type of account</label> 
							  <select name="typeOfAccount" class="form-control" id="typeOfAccount">
							    <option value="Checking">Checking</option>
							    <option value="Saving">Saving</option>
							  </select>
						</div>
						
						<div class="form-group">
							<label>Balance</label> 
							<input type="text" class="form-control" name="balance" placeholder="Balance">
						</div>
                  
                  
                  
					<button type="submit" class="btn btn-primary">Open an account</button>
               </form>
            </div>
         </div>
      </div>
	

</body>

<script src="js/jquery.min.js"></script>
<script src="js/bootstrap.min.js"></script>
<script src="js/scripts.js"></script>
<script src="Login.js"></script>

</html>