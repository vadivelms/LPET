<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>AddUser</title>

<script src="./js/adduser.js"></script>
<style>
body {
	background-color: #eef5f7;
}

.adduser_body {
	-webkit-background-size: cover;
	-moz-background-size: cover;
	-o-background-size: cover;
	background-size: cover;
}

.logout {
	float: right;
}
</style>
<link rel="stylesheet" type="text/css" href="css/adduser.css">

</head>

<body class="adduser_body">
	<%
		String s = (String) request.getAttribute("uname");
		if (s == null) {
			RequestDispatcher rd = request.getRequestDispatcher("/index.jsp");
			rd.forward(request, response);
		}
	%>
	<center>
		<div class="logout">
			<%=request.getAttribute("uname")%><br> <a href="index.jsp">Logout</a>
		</div>

		<form action="Adduser" class="adduser_form" method="post" onsubmit="return valFun()">
			<h1>Add User</h1>
			<table>
				<tr>

					<td>First Name</td>
					<td>: <input class="textbox" type="text" name="firstname"
						placeholder="First Name" onblur="fname(this.value)" required=""></td>
				</tr>
				<tr>
					<td>Last Name</td>
					<td>: <input class="textbox" type="text" name="lastname"
						placeholder="Last Name" required></td>
				</tr>
				<tr>
					<td>Date Of Borth</td>
					<td>: <input class="textbox" type="date" name="dob"
						placeholder="Date Of Birth" required></td>
				</tr>
				<tr>
					<td>Email </td>
					<td>: <input class="textbox" type="email" name="email" id="email"
						placeholder="Email_ID" onblur="sendRequest(this.value)" required></td>
					<br>

				</tr>
				<tr>
					<td>Alternative Email </td>
					<td>: <input class="textbox" type="email" name="aemail" id="aemail"
						placeholder="Alternative Email_ID"
						onblur="confirmMail()" required></td>
					<br>

				</tr>
				<tr>
					<td>Password</td>
					<td>: <input class="textbox" type="password" id="password" name="password"
						placeholder="Password" onblur="validatePassword()" required></td>
				</tr>
				<tr>
					<td>Confirm Password</td>
					<td>: <input class="textbox" type="password" id="cpassword" name="cpassword"
						placeholder="Confirm Password" onblur="confirmPassword()" required></td>
				</tr>
				<tr>
				<td></td><td><span id="message"></span></td>
				</tr>
			</table>
			<input type="reset" value="CLEAR" class="button aubtn">
			<input type="submit" name="addbtn" value="ADD"
				class="button button1 aubtn">

		</form>
	</center>
	<button class="back_button" onclick="goBack()">Go Back</button>
</body>
</html>