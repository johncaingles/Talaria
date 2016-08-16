<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="java.util.ArrayList"%>
<%@page import="model.Product"%>
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
	<h1>DIS BE YOUR ITEMS</h1>
		<% ArrayList<Product> cartItems = (ArrayList<Product>)request.getSession().getAttribute("cart_items"); %>
		<ul class="collection">
			<% for(Product product: cartItems) { %>
			    <li class="collection-item avatar">
			      <img src="img/shoe_0.jpg" alt="" class="circle">
			      <span class="title"><% out.print(product.getName()); %></span>
			      <p><% out.print(product.getCategory()); %> <br>
			         <% out.print(product.getPrice()); %>
			      </p>
			      <a href="#!" class="secondary-content"><i class="material-icons">grade</i></a>
			    </li>
		    <% } %>
	    </ul>
	    
		<a class="waves-effect waves-light btn modal-trigger" href="#creditcard_modal">Buy</a>
    </div>
    
    <div id="creditcard_modal" class="modal">
    <div class="modal-content">
        	<div class="col s12">
        <div class="row">
        		<h4> Gimme your credit card number </h4>
                <form action="" method="post">
                    <div class="input-field col s12">
                        <input name="creditcard_num" value="" id="creditcard_num" type="text" class="validate">
                        <label class="active" for="creditcard_num">Credit card number</label>
                    </div>
                    <h4> Expiration date and security code </h4>
                    <div class="row">
                    <div class="input-field col m3">
                        <input name="creditcard_month" value="" id="creditcard_month" type="text" class="validate">
                        <label class="active" for="creditcard_month">Month</label>
                    </div>
                    <div class="input-field col m5">
                        <input name="creditcard_year" value="" id="creditcard_year" type="text" class="validate">
                        <label class="active" for="creditcard_year">Year</label>
                    </div>
                    <div class="input-field col m4">
                        <input name="creditcard_code" value="" id="creditcard_code" type="text" class="validate">
                        <label class="active" for="creditcard_code">Code</label>
                    </div>
                    </div>
                    <button class="btn waves-effect waves-light blue" type="submit">Login
                        <i class="material-icons right">send</i>
                    </button>
                </form>
        	</div>
        </div>

    <div class="modal-footer">
      <a href="#!" class=" modal-action modal-close waves-effect waves-green btn-flat">Cancel</a>
    </div>

    </div>
</div>
</body>
</html>