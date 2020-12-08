<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>UnLock Account</title>
</head>
<body>
	<div  align="center">
		<h1>Unlock Account Here</h1>
		<font color='green'>${succ}</font>
		 <font color='red'>${fail}</font>
		<form:form action="unlockAcc?email=${userAcc.email}" method="POST"
			modelAttribute="userAcc">
			<table>
				<tr>
					<td>Email</td>
					<td>${userAcc.email}</td>
				</tr>
				<tr>
					<td>Temporary Password</td>
					<td><form:input path="tempPwd" /></td>
				</tr>
				<tr>
					<td>Choose New password</td>
					<td><form:password path="newPwd" /></td>
					
				</tr>
				<tr>
					<td>Confirm password</td>
					<td><form:password path="confirmPwd" /></td>
				</tr>

				<tr>
				<td><input type="reset" value="Reset" >
					<td><input type="submit" value="Register" id="unlockAccount">
					</td>
					<td><a href="index">Login</a></td>

				</tr>
			</table>
		</form:form>
	</div>

</body>
</html>