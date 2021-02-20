<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Logic Programming Evaluation Tool</title>
<link rel="stylesheet" type="text/css" href="css/indexstyle.css">

<style>
body {
	background-color: #eef5f7;
}

</style>
<script>
document.oncontextmenu = function () {
    return false;
};
</script>

</head>
<body>


	<form action="Login" name="loginForm" class="index_form" >
		<center>
		<h1>Logic Programming Evaluation Tool</h1>
			<div id="loginbox">
				<h2>Login To Your Account</h2>

				<h4>
					<table>
						<tr>
							<td>User name</td>
							<td>: <input class="testfield" ty
							pe="text" name="username"	placeholder="Email" required="" value="${username}" ></td>
						<tr>
							<td>Password</td>
							<td>: <input class="testfield" type="password"
								name="password" placeholder="Password" required></td>
						</tr>
					</table>
					<lable class="msg">${message}</lable>
				</h4>
				<input type="submit" class="button" value="Login">
			</div>
		</center>
	</form>
</body>
</html>