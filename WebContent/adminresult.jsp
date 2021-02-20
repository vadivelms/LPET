<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Admin Result</title>
</head>
<script>
	function goBack() {
		window.history.back();
	}
</script>
<style>
body {
	background-color: #eef5f7;
}

.logout {
	float: right;
}
</style>
<link rel="stylesheet" type="text/css" href="css/resultstyle.css">
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
		</div class="content">

		<form action="AdminResult" method="post">
			<h1>Admin Result</h1>
			<div id="menubox">
			<input type="submit" name="individual" class="button"
				value="IndividualResult">
				 <input type="submit"
				name="batch" class="button" value="BatchResult">				
		</div>
		</form>
	</center>
	<button class="back_button" onclick="goBack()">Go Back</button>
</body>


</html>