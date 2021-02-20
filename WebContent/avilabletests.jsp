<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="com.dao.DAO"%>
<%@ page import="java.sql.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Available Tests</title>
<link rel="stylesheet" type="text/css" href="css/avilabletest.css">
</head>
<body>
	<center>
		<form action="StartTest">
			<div class="logout" style="float: right; margin: 0px;">

				<%
					String uname = (String) request.getAttribute("username");
					out.println("<input type='hidden' name='uname'	value='" + uname + "'>");
					uname = uname.substring(0, uname.indexOf('@'));
					out.print(uname);
				%>
				<br> <a href="index.jsp">Logout</a>
			</div>
			<div class="list">
				<table>
					<caption>Available Test</caption>
					<tr>
						<th>Test Name</th>
						<th>Duration</th>
						<th>Date</th>
						<th>Action</th>
					</tr>
					<%
						DAO ob = new DAO();
						ResultSet rs = ob.getAllTests();
						while (rs.next()) {
							out.println("<tr>");
							out.println("<td class='testname'>");
							out.println("<lable class='names'>" + rs.getString("TEST_NAME"));
							out.println("</td>");
							out.println("<td class='testname'>");
							out.println("<lable class='duration'>" + rs.getString("TEST_DURATION"));
							out.println("</td>");
							out.println("<td class='testname'>");
							out.println("<lable class='duration'>" + rs.getString("TEST_DATE"));
							out.println("</td>");
							out.println("<td class='btnlist'>");
							out.println("<input type='submit' class='testbtn' name=" + rs.getString("TEST_ID")
									+ " value=Take&nbsp;Test>");
							out.println("</td>");
							out.println("</tr>");
						}
					%>
				</table>
			</div>
		</form>
	</center>

</body>
</html>