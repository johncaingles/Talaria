<%@ page import="model.Account" %>
<%   if ((session.getAttribute("user_account") != null) ){ %>
<%		if(((Account)session.getAttribute("user_account")).getPrivilegeLevel().equals("4")){ %>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Administration Panel</title>

	<jsp:include page="dependencies.jsp" />

<head>
<body>
	
	<jsp:include page="nav-bar.jsp" />
	
	<h1 class="center">Hello, Administrator. </h1> 
	<h6 class="center">Hail Hydra!</h6>
    <div class="container">
	    	
		  	<% if (request.getAttribute("creationStatus") != null) { %>
			<div>
			     <h6 class="red-text"><%=request.getAttribute("creationStatus")%></h6>
			</div>
			<% } 
			request.setAttribute("creationStatus", null); %>
		    <div class="row">
		    <div class="col s12">
		      <ul class="tabs">
		        <li class="tab col s6"><a onclick="Materialize.showStaggeredList('#createPM')" href="#PM">Create new Product Manager</a></li>
		        <li class="tab col s6"><a onclick="Materialize.showStaggeredList('#createAM')" href="#AM">Create new Account Manager</a></li>
		      </ul>
		    </div>
		  </div>
		  <div class="row" id="PM">
		    	<form action="AdminCreateServlet" method="post" id="createPM">
				  <div class="input-field col s12">
				    <label for="username">Username:</label>
				    <input type="text" class="validate" id="username" name="username" required="" aria-required="true">
				  </div>
				  <div class="input-field col s12">
				    <label for="pwd">Temporary Password (Expires in 24 hours):</label>
				    <input type="password" class="validate" id="pwd" name="password" required="" aria-required="true">
				  </div>
				  <input type="hidden" class="validate" name="accType" value="2">
				  <button type="submit" class="btn red lighten-1">Create</button>
				</form>
          </div>
          
          <div class="row" id="AM">
		    	<form action="AdminCreateServlet" method="post" id="createAM">
				  <div class="input-field col s12">
				    <label for="username">Username:</label>
				    <input type="text" class="validate" id="username" name="username" required="" aria-required="true">
				  </div>
				  <div class="input-field col s12">
				    <label for="pwd">Temporary Password (Expires in 24 hours):</label>
				    <input type="password" class="validate" id="pwd" name="password" required="" aria-required="true">
				  </div>
				  <input type="hidden" class="validate" name="accType" value="3">
				  <button type="submit" class="btn red lighten-1">Create</button>
				</form>
          </div>
          </div>
    <jsp:include page="footer.jsp" />
</body>
</html>
<% }} else { %> <jsp:include page="forbidden.jsp" /> <% } %>