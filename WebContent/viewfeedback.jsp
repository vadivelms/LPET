<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="com.dao.DAO"%>
<%@ page import="java.sql.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Feedbacks</title>
<style>
body {
	background-color: #eef5f7;
}

table {
	border-collapse: collapse;
	text-align: center;
	width: 80%;
	box-shadow: 4px 4px 5px #888888;
}

th, td {
	padding: 8px;
}

tr:nth-child(even) {
	background-color: #f2f2f2
}

tr:nth-child(odd) {
	background-color: #eae9fe
}

th {
	background-color: #2116e7;
	color: white;
}

caption {
	margin-top: 7%;
	font-size: 20px;
	font-weight: bold;
}
</style>
</head>
<body>
	<center>
		<table>
			<caption>User Feedbacks</caption>
			<tr>
				<th>Name</th>
				<th>Email</th>
				<th>Feedback</th>
			</tr>
			<%
				DAO ob = new DAO();
				ResultSet rs = ob.getFeedback();
				while (rs.next()) {
					out.println("<tr>");
					out.println("<td>");
					out.println(rs.getString("NAME"));
					out.println("</td>");
					out.println("<td>");
					out.println(rs.getString("EMAIL"));
					out.println("</td>");
					out.println("<td>");
					out.println(rs.getString("COMMENTS"));
					out.println("</td>");
					out.println("</tr>");
				}
			%>
		</table>
	</center>
</body>
</html>