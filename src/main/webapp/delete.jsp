<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Delete your account</title>

<link href="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
<script src="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
<script src="//code.jquery.com/jquery-1.11.1.min.js"></script>

<link rel="stylesheet" href="mystyle.css">

</head>
<body>

	<div class="sidenav">
         <div class="login-main-text">
            <h2>Sorry to see you go, ${pseudofirstName} ${pseudoLastName}!<br></h2>
            <p><h4>Your account with id ${pseudoAccountId} is no longer valid.</h4></p>		
			
			
         </div>
      </div>
      
      
	<div class="main">
         <div class="col-md-6 col-sm-12">
            <div class="login-form3">
               
               
                		<div class="form-group">
  		            		<form action="http://localhost:8080/banking-app">
								<button type="submit" class="btn btn-black">Home Page</button>
							</form>
						</div>
                  
                  
            </div>
         </div>
      </div>
      
</body>
</html>