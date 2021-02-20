<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Result</title>
<style>
.navigations {
	float: right;
	margin-top: 2px;
}

.report_card {
	margin-top: 7%;
	
	width: 500px;
	padding: 20px;
	background-color: windowframe;
	text-align: center;
	font-size: 30px;
	font-weight: bold;
}

.feed_from {
	margin-top: 20%;
}
td{
text-align: center;
}
table{
margin-left: 20%;
margin-top: 10%;
}

.nextbtn {
	border: 1px solid #382dec;
	font-size: 20px;
	background-color: #e2f1f6;
	padding: 10px 30px;
	width: 150px;
}

.nextbtn:HOVER {
	background-color: #382dec;
	color: white;
}

.content {
	border: 2px;
}
body {
	background-color: #eef5f7;
}

</style>
</head>
<body>
	<div class="navigations">
		<%=request.getAttribute("username")%>
	</div>
	<center>

		<div class="report_card">

			<table>
				<tr>
					<td>Total Score</td>
					<td>: 100 %</td>
				</tr>
				<tr>
					<td>Obtained Score</td>
					<td>: <%=request.getAttribute("marks")%> %
					</td>
				</tr>
				<tr>
					<td>Status </td>
					<td>: <%=request.getAttribute("status")%> 
					</td>
					
					
				</tr>
			</table>
			<form action="feedback.jsp" class="feed_from">
				<input type="submit" value="Next" class="nextbtn">
			</form>

		</div>

	</center>
</body>
</html>