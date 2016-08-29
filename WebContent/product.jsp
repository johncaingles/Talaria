<%@ page import="model.Account" %>
<%@ page import="java.sql.ResultSet" %>
<%@page import="java.util.ArrayList"%>
<%@page import="model.Product"%>
<%@page import="model.Transaction" %>
<% String priv = "0"; %>
<%   if ((session.getAttribute("user_account") != null) ){
	  	priv = ((Account)session.getAttribute("user_account")).getPrivilegeLevel(); 
	 }
	 if(priv.equals("1") || priv.equals("0")){ %>

<%@page import="model.Product"%>
<%@page import="model.Model"%>
<%@ page import="org.owasp.encoder.*" %>
<html>
	<head>
		<!-- <link rel="stylesheet" type="text/css" href="css\skeleton.css"> -->
	<jsp:include page="dependencies.jsp" />
		<style>

			/* .header{
				background-color: rgb(138, 138, 92);
				height: 47px;
				width: 100%;
				position: fixed;
				z-index: 1;
			}

			.title{
				font:;
			}

			.productBox{
				padding:5px;
				border-radius: 5px;
				margin-left: 400px;
				margin-top: 280px;
				float:left;
				border: 1px solid black;
				margin-right: 10px;
			}

			.productDescription{
/* 				padding: 8px; */
/* 				border-radius: 5px; */
/* 				margin-top: 280px; */
				height: 300px; /* pwede ata to tanggalin after*/
				width: 350px;
				border: 1px solid black;
				float: left;
			}

			.image{
				height: 300px;
				width: 500px;
			}
			.addToCart{
				margin-left:500px; 
				height:88px;
				width:350px;
				float:left;
			} */
			
		</style>
	</head>

	<body>
		<jsp:include page="nav-bar.jsp" />
		<% Product product = (Product)request.getAttribute("product"); %>
		<div class = "container">
			<div class = "row">
				<div class = "left col s8">
					<div class = "card-panel">
						<div class = "row">
							<section>
								<h4 class="center" style="color: #666633"><% out.print(Encode.forHtml(product.getName())); %></h4>
							</section>
						</div>
						<div class="divider"></div>
						<div class = "row">
							<section>
								<img class = "col m8 materialboxed" src = "img/shoe_0.jpg" style= "width:50%; height: auto;">
								<div class="block col m4">
									<br><br>
									<h4 class="light">$<% out.print(product.getPrice()); %></h4>
									<br>
										Category: <% out.print(product.getCategory()); %>
									<br>
								</div>
							</section>
						</div>
					</div>
					<div class="divider"></div>
					<h4> <i class="medium material-icons">question_answer</i>Reviews</h4>
					<div class = "row">
							<ul class="collection">
								<% ResultSet rs = Model.getProductReview(product.getProd_id()); %>
								<% while(rs.next()) { %>
								    <li class="collection-item avatar">
								      <img src="img/shoe_0.jpg" alt="" class="circle">
								      <span class="title"><% out.print(Encode.forHtml(rs.getString("username"))); %></span>
								      <p>
								      	<% out.print(Encode.forHtml(rs.getString("review"))); %>
								      </p>
								      <div class="secondary-content">
								      	<% for(int i=0; i<rs.getInt("rating"); i++){ %>
								      		<i class="material-icons">stars</i>
							      		<% }%>
								      </div>
								    </li>
							    <% } %>
						    </ul>
					    </div>
				</div>
		
				<div class = "card-panel right col s4">
					<div class="section">
						<% if(!priv.equals("0")){ %>
						<form class="col s12" action="AddToCartServlet" method="post" >
							<input type="hidden" name="productID" value="<% out.print(product.getProd_id()); %>" >
							<div class="input-field">
							    <label for="quantity">Quantity</label>
							    <input type="number" min="1" value="1" class="form-control" id="quantity" name="quantity" required="" aria-required="true">
							 </div>
							<button class="col s12 btn waves-effect waves-light blue" type="submit" name="action">Add to Cart
							    <i class="material-icons right">shopping_cart</i>
							  </button>
						</form>
						<section>
						  <% ArrayList<Transaction> cartItems = (ArrayList<Transaction>)request.getSession().getAttribute("cart_items"); %>
							<% double total = 0.00; %>
							
							<ul class="collection">
								<% if(cartItems != null){ %>
									<% for(Transaction tran: cartItems) { %>
										<%Product cartProduct = tran.getProd(); 
											total += cartProduct.getPrice() * tran.getQuantity();%>
									    <li class="collection-item avatar">
									      <img src="img/shoe_0.jpg" alt="" class="circle">
									      <span class="title"><% out.print(Encode.forHtml(cartProduct.getName())); %></span>
									      <p><% out.print(Encode.forHtml(cartProduct.getCategory())); %> <br>
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
					    </section>
						<% } else { %>
							<h5 class="center"><a class="modal-trigger" href="#login_modal">Login</a> to buy this product!</h5>
							<div class="input-field">
							    <label for="quantity">Quantity</label>
							    <input disabled type="text" class="form-control" id="quantity" name="quantity" required="" aria-required="true">
							 </div>
							<button class="btn waves-effect waves-light blue disabled" type="submit" name="action">Add to Cart
							    <i class="material-icons right">shopping_cart</i>
							  </button>
						<% } %>
					</div>
				</div>
			</div>
			
		</div>
		<jsp:include page="footer.jsp" />
		<script>
		$(document).ready(function(){
		    $('.materialboxed').materialbox();
		  }); %>
		  </script>
	</body>

</html>
<% } else { %> <jsp:include page="forbidden.jsp" /> <% } %>