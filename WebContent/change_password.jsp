<%@ page import="model.Account" %>
<% String priv = "0"; %>
<%   if ((session.getAttribute("user_account") != null) ){
	  	priv = ((Account)session.getAttribute("user_account")).getPrivilegeLevel(); 
	 }
	 if(priv.equals("1")||priv.equals("2")||priv.equals("3")||priv.equals("4")){%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="java.util.ArrayList"%>
<%@page import="model.Product"%>
<%@page import="model.Model" %>
<%@page import="java.util.HashMap"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>

	<jsp:include page="dependencies.jsp" />
</head>
<body>
	<jsp:include page="nav-bar.jsp" />
	<div class="container">
		
		<section>
			<form action="ChangePasswordServlet" method="post">
				<div class="input-field col s12">
	                <input name="old_password" value="" id="old_password" type="password" class="validate" required="" aria-required="true">
	                <label class="active" for="old_password">Old Password</label>
	            </div>
				<div class="input-field col s12">
	                <input name="new_password" value="" id="new_password" type="password" class="validate" required="" aria-required="true">
	                <label class="active" for="new_password">New Password</label>
	            </div>
				<div class="input-field col s12">
	                <input name="confirm_new_password" value="" id="confirm_new_password" type="password" class="validate" required="" aria-required="true">
	                <label class="active" for="confirm_new_password">Confirm New Password</label>
	            </div>
	            <button class="btn waves-effect waves-light blue" type="submit">Confirm
                        <i class="material-icons right">send</i>
                </button>
            </form>
		</section>
		
	</div>

    <jsp:include page="footer.jsp" />
</body>
</html>
<% } else { %> <jsp:include page="forbidden.jsp" /> <% } %>