
<%@page import="model.Product"%>
<html>
	<head>
		<link rel="stylesheet" type="text/css" href="css\skeleton.css">
	<jsp:include page="dependencies.jsp" />
		<style>

			.header{
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
			}
			
		</style>
	</head>

	<body bgcolor = "#d6d6c2">
		<jsp:include page="nav-bar.jsp" />
		<div class = "row">
			<div class = "productBox">
				<img class = "image" src = "C:\Users\User\Pictures\presto.jpg">
			</div>
	
			<div class = productDescription>
				Tangina this product so nice
				<br>
				<% Product product = (Product)request.getAttribute("product"); %>
				<% out.print(product.getCategory()); %>
				<br>
				<% out.print(product.getName()); %>
				<br>
				<% out.print(product.getPrice()); %>
			</div>
		</div>
		<div class = "row" style ="margin-top:13px;">
			<form action="AddToCartServlet" method="post" >
				<input type="hidden" name="productID" value="<% out.print(product.getProd_id()); %>" >
				<div class="form-group">
					<label for="quantity">Quantity</label>
					<input type="quantity" name="quantity" />
				</div>
				<input type = "submit" class = "addToCart" value = "Add To Cart" style="background-color:rgb(191, 191, 191);">
			</form>
		</div>
	</body>


</html>