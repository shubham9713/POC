<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Forgot Password</title>
<style>
input[type=text]:valid{
border:2px solid green;
box-shadow: 2px 2px 3px green;
}
input[type=text]:invalid{
border:2px solid red;
box-shadow: 2px 2px 3px red;
}
</style>
</head>
<body>
<div  align="center">
		<h1>Recover Password Here</h1>
		<font color='green'>${succ}</font>
		 <font color='red'>${fail}</font>
		<form action="forgotPwd" method="POST">
			<table>
				<tr>
					<td>Email</td>
					<td><input type="text" name="email" pattern="[a-z0-9._%+-]+@[a-z0-9.-]+\.[a-z]{2,}$" required/></td>
				</tr>
				
				<tr>
				<td><input type="reset" value="Reset" >
					<td><input type="submit" value="Register" id="unlockAccount">
					</td>
					<td><a href="index">Login</a></td>

				</tr>
			</table>
		</form>
	</div>

</body>
</html>