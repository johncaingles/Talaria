<html>
	<head>
		<link rel="stylesheet" type="text/css" href="css\skeleton.css">
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
				padding: 8px;
				border-radius: 5px;
				margin-top: 280px;
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
		<div class = "header">

		</div>
		<div class = "row">
		<div class = "productBox">
			<img class = "image" src = "C:\Users\User\Pictures\presto.jpg">
		</div>

		<div class = productDescription>
			Tangina this product so nice
		</div>
		</div>
		<div class = "row" style ="margin-top:13px;">
			<input type = "button" class = "addToCart" onClick = "addToCart();" value = "Add To Cart" style="background-color:rgb(191, 191, 191);">
		</div>
	</body>


</html>