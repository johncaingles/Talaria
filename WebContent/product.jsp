<%@ page import="model.Account" %>
<%@ page import="java.sql.ResultSet" %>
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
							<h4 class="center" style="color: #666633"><% out.print(product.getName()); %></h4>
							<img class = "col m8 responsive-img" src = "img/shoe_0.jpg" style= "width:50%; height: auto;">
							<div class="block col m4">
								<br><br>
								<h4 class="light">$<% out.print(product.getPrice()); %></h4>
								<br>
									Category: <% out.print(product.getCategory()); %>
								<br>
							</div>
						</div>
					</div>
					<div class = "row">
							<ul class="collection">
								<% ResultSet rs = Model.getProductReview(product.getProd_id()); %>
								<% while(rs.next()) { %>
								    <li class="collection-item avatar">
								      <img src="img/shoe_0.jpg" alt="" class="circle">
								      <span class="title"><% out.print(rs.getString("username")); %></span>
								      <p>
								      	<% out.print(rs.getString("review")); %>
								      </p>
								      <a href="#!" class="secondary-content"><i class="material-icons">grade</i></a>
								    </li>
							    <% } %>
						    </ul>
					    </div>
				</div>
		
				<div class = "card-panel right col s4">
					<div class="section">
						<form action="AddToCartServlet" method="post" >
							<input type="hidden" name="productID" value="<% out.print(product.getProd_id()); %>" >
							<div class="form-group">
							    <label for="quantity">Quantity:</label>
							    <input type="text" class="form-control" id="quantity" name="quantity">
							 </div>
							<button class="btn waves-effect waves-light blue" type="submit" name="action">Add to Cart
							    <i class="material-icons right">shopping_cart</i>
							  </button>
						</form>
					</div>
				</div>
			</div>
			
		</div>
	</body>

</html>
<% } else { %> <jsp:include page="forbidden.jsp" /> <% } %>