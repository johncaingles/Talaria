<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="java.util.ArrayList"%>
<%@page import="model.Product"%>
<%@page import="model.Account"%>
<%@page import="model.Model"%>
<%@ page import="org.owasp.encoder.Encode" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<jsp:include page="dependencies.jsp" />

<head>
<body>

	<jsp:include page="nav-bar.jsp" />
	<% String accountID = String.valueOf(((Account)(request.getSession().getAttribute("user_account"))).getAccountID()); %>
	<% ArrayList<Product> productList = Model.getBoughtProducts(Integer.parseInt(accountID)); %>
	<div class="container">
	<% ArrayList<Product> cartItems = (ArrayList<Product>)request.getSession().getAttribute("cart_items"); %>
		<ul class="collection">
			<% for(Product product: productList) { %>
			    <li class="collection-item avatar">
			      <img src="img/shoe_0.jpg" alt="" class="circle">
			      <span class="title"><% out.print(Encode.forHtml(product.getName())); %></span>
			      <p><% out.print(product.getCategory()); %> <br>
			         <% out.print(product.getPrice()); %>
			      </p>
			      <a href="#review_modal_<% out.print(product.getProd_id()); %>" class="secondary-content modal-trigger"><i class="material-icons">grade</i></a>
			    </li>
			    
			    <div id="review_modal_<% out.print(product.getProd_id()); %>" class="modal">
				            <div class="modal-content">
					        	<div class="col s12">
					        		<h4> Write a Review </h4>
					                <form action="AddReviewServlet" method="post">
					                <input type="hidden" name="product_id" value="<% out.print(product.getProd_id()); %>">
					                    <div class="input-field col s12">
					                        <input name="review" value="" id="review" type="text" class="validate">
					                        <label class="active" for="review">Name</label>
					                    </div>
					                        <button class="btn waves-effect waves-light blue" type="submit">Apply
					                        <i class="material-icons right">send</i>
					                    </button>
					                </form>
					        	</div>
					        </div>
					        <div class="modal-footer">
						      <a href="#!" class=" modal-action modal-close waves-effect waves-green btn-flat">Cancel</a>
						    </div>
				        </div>
		    <% } %>
	    </ul>
    </div>
    
    
    
</body>
</html>