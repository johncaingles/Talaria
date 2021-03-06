<%@ page import="model.Account" %>
<%   if ((session.getAttribute("user_account") != null) ){ %>
<%		if(((Account)session.getAttribute("user_account")).getPrivilegeLevel().equals("1")){ %>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="java.util.ArrayList"%>
<%@page import="model.Product"%>
<%@page import="model.Account"%>
<%@page import="model.Model"%>
<%@page import="java.sql.ResultSet" %>
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
		<div class="row">
			<div class="col s5">
				<% ArrayList<Product> cartItems = (ArrayList<Product>)request.getSession().getAttribute("cart_items"); %>
				<ul class="collection with-header">
					<li class="collection-header"><h4>Bought Items</h4></li>
					<% for(Product product: productList) { %>
					    <li class="collection-item avatar">
					      <img src="img/shoe_0.jpg" alt="" class="circle">
					      <span class="title"><% out.print(Encode.forHtml(product.getName())); %></span>
					      <p><% out.print(Encode.forHtml(product.getCategory())); %> <br>
					         $<% out.print(product.getPrice()); %>
					      </p>
					      <a href="#review_modal_<% out.print(product.getProd_id()); %>" class="secondary-content modal-trigger">Add Review<i class="medium material-icons">note_add</i></a>
					    </li>
					    
					    <div id="review_modal_<% out.print(product.getProd_id()); %>" class="modal">
						            <div class="modal-content">
							        	<div class="col s12">
							        		<h4> Write a Review </h4>
							                <form action="AddReviewServlet" method="post">
							                	<h5>Your Rating</h5>
								                <p class="range-field">
											      <input name="rating" type="range" id="rating" min="1" max="5" />
											    </p>
							                	<input type="hidden" name="product_id" value="<% out.print(product.getProd_id()); %>">
							                    <div class="input-field col s12">
							                        <textarea length="350" name="review" value="" id="review" type="text" class="validate materialize-textarea" required="" aria-required="true"></textarea>
							                        <label class="active" for="review">Review</label>
							                    </div>
							                        <button class="btn waves-effect waves-light blue" type="submit">Write Review
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
		    <div class="col s7">
		    	<% ResultSet rs = Model.getReviewsByUser(Integer.valueOf(accountID)); %>
				<ul class="collection with-header">
					<li class="collection-header"><h4>Your Reviews</h4></li>
					<% while(rs.next()) { %>
					    <li class="collection-item avatar">
					      <img src="img/shoe_0.jpg" alt="" class="circle">
					      <span class="title"><% out.print(rs.getString("name")); %></span>
					      <p><% out.print(rs.getString("review")); %>
					      </p>
					      <div class="secondary-content">
					      <% for(int i=0; i<rs.getInt("rating"); i++){ %>
					      		<i class="material-icons">stars</i>
			        		<% }%>
				      		</div>
					    </li>
				    <% } %>
		    </div>
	    </div>
    </div>
    
    
    
</body>
</html>
<% }} else { %> <jsp:include page="forbidden.jsp" /> <% } %>