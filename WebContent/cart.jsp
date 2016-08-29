<%@ page import="model.Account" %>
<% String priv = "0"; %>
<%   if ((session.getAttribute("user_account") != null) ){
	  	priv = ((Account)session.getAttribute("user_account")).getPrivilegeLevel(); 
	 }
	 if(priv.equals("1") || priv.equals("0")){%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="java.util.ArrayList"%>
<%@page import="model.Product"%>
<%@page import="model.Transaction" %>
<%@ page import="org.owasp.encoder.Encode" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<style>
	.modal {overflow-y: hidden !important ;}
</style>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<jsp:include page="dependencies.jsp" />
</head>
<body>
	<jsp:include page="nav-bar.jsp" />
	
	<div class="container">
	<h3>Shopping Cart</h3>
		<% ArrayList<Transaction> cartItems = (ArrayList<Transaction>)request.getSession().getAttribute("cart_items"); %>
		<% double total = 0.00; %>
		
		<ul class="collection">
			<% if(cartItems != null){ %>
				<% for(Transaction tran: cartItems) { %>
					<%Product product = tran.getProd(); 
						total += product.getPrice() * tran.getQuantity();%>
				    <li class="collection-item avatar">
				      <img src="img/shoe_0.jpg" alt="" class="circle">
				      <span class="title"><% out.print(Encode.forHtml(product.getName())); %></span>
				      <p><% out.print(Encode.forHtml(product.getCategory())); %> <br>
				         <% out.print("Quantity: " + tran.getQuantity()); %>
				      </p>
				      <div class="secondary-content"><h5>$<% out.print(product.getPrice() * tran.getQuantity()); %></h5></div>
				    </li>
			    <% } %>
		    <% } %>
		    <li class="collection-item">
			      <h5>Total: </h5>
			      <div class="secondary-content"><h5>$<% out.print(total); %></h5></div>
			    </li>
	    </ul>
	    
		<a class="waves-effect waves-light btn modal-trigger" href="#creditcard_modal">Checkout</a>
    </div>
    
    <div id="creditcard_modal" class="modal">
    <div class="modal-content">
        	<div class="col s12">
        <div class="row">
        		<h4> Gimme your credit card number </h4>
                <form action="TransactionServlet" method="post">
                    <div class="input-field col s12">
                        <input name="creditcard_num" value="" id="creditcard_num" type="text" pattern="\d{16}" length="16" oninput="setCustomValidity('')" oninvalid="setCustomValidity('Enter a 16-digit number')" class="validate" required="" aria-required="true">
                        <label class="active" for="creditcard_num">Credit card number</label>
                    </div>
                    <h4> Expiration date and security code </h4>
                    <div class="row">
                    <div class="input-field col m3">
					    <select name="ccMonth" required="" aria-required="true">
						      <option value="" selected disabled>Select Month</option>
						      <option value="jan">January</option>
						      <option value="feb">February</option>
						      <option value="mar">March</option>
						      <option value="apr">April</option>
						      <option value="may">May</option>
						      <option value="jun">June</option>
						      <option value="jul">July</option>
						      <option value="aug">August</option>
						      <option value="sep">September</option>
						      <option value="oct">October</option>
						      <option value="nov">November</option>
						      <option value="dec">December</option>
					    </select>
                    </div>
                    <div class="input-field col m5">
                        <select name="ccYear" required="" aria-required="true">
						      <option value="" disabled selected>Select Year</option>
						      <option value="2016">2016</option>
						      <option value="2017">2017</option>
						      <option value="2018">2018</option>
						      <option value="2019">2019</option>
						      <option value="2020">2020</option>
						      <option value="2021">2021</option>
						      <option value="2022">2022</option>
						      <option value="2023">2023</option>
						      <option value="2024">2024</option>
						      <option value="2025">2025</option>
						      <option value="2026">2026</option>
						      <option value="2027">2027</option>
					    </select>
                    </div>
                    <div class="input-field col m4">
                        <input name="creditcard_code" value="" id="creditcard_code" pattern="\d{3}" length="3" oninput="setCustomValidity('')" oninvalid="setCustomValidity('Enter a 3-digit number')" type="text" class="validate" required="" aria-required="true">
                        <label class="active" for="creditcard_code">Code</label>
                    </div>
                    </div>
                    <button class="btn waves-effect waves-light blue" type="submit">Purchase
                        <i class="material-icons right">shop</i>
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
<% } else { %> <jsp:include page="forbidden.jsp" /> <% } %>