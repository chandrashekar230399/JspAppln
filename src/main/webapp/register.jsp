<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Register form</title>
</head>
<body>
	<form action="regForm" method="post">
	Name:<input type="text" name="uname"><br></br>
	Email:<input type="text" name="email"><br></br>
	Password:<input type="password" name="pswd"><br></br>
	Gender:<input type="radio" name="gender" value="Male">Male
			<input type="radio" name="gender" value="Female">Female<br></br>
	City:<select name="city">
		<option>Select City</option>
		<option>Delhi</option>
		<option>Hyderabad</option>
		<option>Mumbai</option>
		<option>Chennai</option>
		</select><br></br>
		<input type="submit" value="Register">
	</form>
</body>
</html>