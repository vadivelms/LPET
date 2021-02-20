<%@page import="java.sql.ResultSet"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="com.dao.DAO"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Create Test</title>
<script src="js/crestetestjs.js"></script>
<link rel="stylesheet" type="text/css" href="css/createteststyle.css">

</head>
<body>
	<%
		String s = (String) request.getAttribute("uname");
		if (s == null) {
			RequestDispatcher rd = request.getRequestDispatcher("/index.jsp");
			rd.forward(request, response);
		}
	%>
	<form action="CreateTest" method="post">
		<div class="logout">
			<%=request.getAttribute("uname")%><br> <a href="index.jsp">Logout</a>
		</div>
		<h1>Create Test by Admin People</h1>
		
		<table>
			<tr>
				<td>Test Name</td>
				<td>: <input type="text" name="testname" class="inputfield"
					required=""><br></td>
			</tr>
			<tr>
				<td>Test Duration</td>
				<td>: <input type="number" min="1" name="duration" class="inputfield"
					required=""> Minutes</td>
			</tr>
			<tr>
				<td>Test Date</td>
				<td>: <input type="date" name="date" class="inputfield"
					required=""></td>
			</tr>
			
		</table>

<h2>Select Questions For The Test:</h2>
		<div class="allquestions">
			<%
				DAO dobj = new DAO();
				ResultSet rs = dobj.getAllQuestions();

				int count = 1;
				while (rs.next()) {

					String title = rs.getString("title");
					String id = rs.getString("id");
					if (title != null) {
						out.println("<input type='checkbox' class='question' value='" + id + "'"
								+ " name='question' onclick='addQuestion(this);'><lable id='" + id + "'" + ">" + title
								+ "</lable><br>");
						count++;
					}
				}
			%>
		</div>

		<input type="submit" class="button" value="Create"
			onclick="confirmTest();">
		<button class="button back" onclick="goBack()">Go Back</button>
	</form>
</body>
</html>