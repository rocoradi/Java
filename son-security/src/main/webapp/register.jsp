<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="sp_f" %>

<!DOCTYPE html>
<html>
	<head>
		<title>SPRING SECURITY</title>
		<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta/css/bootstrap.min.css" integrity="sha384-/Y6pD6FV/Vv2HJnA6t+vslU6fwYXjCFtcEpHbNJ0lyAFsXTsjBbfaDjzALeQsN6M" crossorigin="anonymous">
	</head>
	<body>
		<div class="container">
		    <div class="panel">
		       <div class="panel-heading">
		          <h2>Register new account</h2>
		       </div>
		       <div class="panel-body">
			          <sp_f:form method="POST" modelAttribute="user" class="form">
			              <spring:bind path="username">
			                 <sp_f:input type="text" path="username" class="form-control" placeholder="Enter your username here"></sp_f:input>
			                 <sp_f:errors path="username"></sp_f:errors>
			              </spring:bind>
			              <spring:bind path="password">
			                 <sp_f:input type="password" class="form-control" path="password" placeholder="Enter your password here"></sp_f:input>
			                 <sp_f:errors path="password"></sp_f:errors>
			              </spring:bind>
			              
			              <button type="submit" class="btn btn-lg btn-block btn-primary">Create</button>
			          </sp_f:form>
		       </div>
		    </div>
		</div>
	<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
	<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.11.0/umd/popper.min.js" integrity="sha384-b/U6ypiBEHpOf/4+1nzFpr53nxSS+GLCkfwBdFNTxtclqqenISfwAzpKaMNFNmj4" crossorigin="anonymous"></script>
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta/js/bootstrap.min.js" integrity="sha384-h0AbiXch4ZDo7tp9hKZ4TsHbi047NrKGLO3SEJAg45jXxnGIfYzk4Si90RDIqNm1" crossorigin="anonymous"></script>
	</body>
</html>	