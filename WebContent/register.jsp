<html>
	<head>
		<link rel="stylesheet" type="text/css" href="css\skeleton.css">
		<style>
		.register{
			margin-top: 10%;
			margin-left: 10%;
			margin-right:3%;
			float:left;
		}

		</style>
	</head>
	<body bgcolor = "#d6d6c2">
		
			<form action="RegisterServlet" method="post">
				<div class = "register">
					<input type = "text" placeholder = "First Name" name = "first_name" required="" aria-required="true"><br>
					<input type = "text" maxlength = "1" placeholder = "MI" size = "3px"name = "middle_name" required="" aria-required="true"><br>
					<input type = "text" placeholder = "Last Name" name = "last_name" required="" aria-required="true"><br>
					<input type = "email" placeholder = "E-Mail" name = "email" required="" aria-required="true"><br>
					<input type = "text" placeholder = "Username" name = "username" required="" aria-required="true"><br>
					<input type = "password" placeholder = "Password" name = "password" required="" aria-required="true"><br>
					<input type = "password" placeholder = "Confirm Password" name = "confirm_password" required="" aria-required="true">					
				</div>

				<div class="register">
					Billing Address:<br>
					<input type = "text" placeholder = "House #" name = "bil_house_num" required="" aria-required="true"><br>
					<input type = "text" placeholder = "Street" name = "bil_street" required="" aria-required="true"><br>
					<input type = "text" placeholder = "Subdivision" name = "bil_subdivision" required="" aria-required="true"><br>
					<input type = "text" placeholder = "City" name = "bil_city" required="" aria-required="true"><br>
					<input type = "number" placeholder = "Postal Code" maxlength = "1" name = "bil_postal_code" required="" aria-required="true"><br>
					<input type = "text" placeholder = "Country" name = "bil_country" required="" aria-required="true"><br>
				</div>

				<div class="register">
					Shipping Address:<br>
					<input type = "text" placeholder = "House #" name = "ship_house_num" required="" aria-required="true"><br>
					<input type = "text" placeholder = "Street" name = "ship_street" required="" aria-required="true"><br>
					<input type = "text" placeholder = "Subdivision" name = "ship_subdivision" required="" aria-required="true"><br>
					<input type = "text" placeholder = "City" name = "ship_city" required="" aria-required="true"><br>
					<input type = "number" placeholder = "Postal Code" maxlength = "1" name = "ship_postal_code" required="" aria-required="true"><br>
					<input type = "text" placeholder = "Country" name = "ship_country" required="" aria-required="true"><br>
					<input type = "submit" value = "submit" style="background-color:rgb(191, 191, 191);">
				</div>
			</form>
		</div>
	</body>
</html>