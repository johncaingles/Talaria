<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<jsp:include page="dependencies.jsp" />
<title>Login</title>
</head>
<body>
	<jsp:include page="nav-bar.jsp" />
	<h1>KAINANO</h1>
	<div class="container">
		<form action="LoginServlet" method="post">
			<div class="form-group">
				<label for="username">Username:</label>
				<input type="text" name="username" />
			</div>
			
			<div class="form-group">
				<label for="password">Password:</label>
				<input type="password" name="password" />
			</div>
			<br/><br/>
			
			<button type="submit" class="btn btn-default">Login</button>
		</form>
	</div>
</body>
</html>