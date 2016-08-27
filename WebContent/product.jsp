<%@ page import="model.Account" %>
<% String priv = "0"; %>
<%   if ((session.getAttribute("user_account") != null) ){
	  	priv = ((Account)session.getAttribute("user_account")).getPrivilegeLevel(); 
	 }
	 if(priv.equals("1") || priv.equals("0")){ %>

<%@page import="model.Product"%>
<%@page import="model.Model"%>
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
				<div class = "card-panel left col s8">
					<div class = "row">
						<h4 class="center indigo-text"><% out.print(product.getName()); %></h4>
						<img class = "col m8 responsive-img" src = "img/shoe_0.jpg" style= "width:50%; height: auto;">
						<div class="block col m4">
							<br><br>
							<h4 class="light">$<% out.print(product.getPrice()); %></h4>
							<br>
								Category: <% out.print(product.getCategory()); %>
							<br>
						</div>
					</div>
					<% for(String review:Model.getProductReview(product.getProd_id())){ 
								out.print("<p>"+review+"</p>"); 
								}%>
				</div>
		
				<div class = "card-panel right col s4">
					<form action="AddToCartServlet" method="post" >
						<input type="hidden" name="productID" value="<% out.print(product.getProd_id()); %>" >
						<div class="row">
							<label for="quantity">Quantity</label>
							<input type="quantity" name="quantity" />
						</div>
						<button class="row btn waves-effect waves-light" type="submit" name="action">Submit
						    <i class="material-icons right">Add to Cart</i>
						  </button>
					</form>
				</div>
			</div>
			
		</div>
	</body>

</html>
<% } else { %> <jsp:include page="forbidden.jsp" /> <% } %>