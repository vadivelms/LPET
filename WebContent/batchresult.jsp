<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="com.dao.DAO"%>
<%@ page import="java.sql.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Batch Result</title>
<style>
.form_box {
	background-color: #b7bfcc;
	width: 80%;
	margin-top: 5%;
	padding: 20px;
	font-size: 20px;
}
body {
	background-color: #eef5f7;
}
.button,.backbutton {
	background-color: #450cf2;
	border:none;
	color: white;
	padding: 15px 32px;
	text-align: center;
	font-family:cursive;
	width: 220px;
	display: inline-block;
	font-size: 16px;
	text-transform:uppercase;
	font-weight:bold;
	margin: 4px 2px;
	cursor: pointer;
	box-shadow: 0 8px 16px 0 rgba(0, 0, 0, 0.2), 0 6px 20px 0
		rgba(0, 0, 0, 0.19);
	display: inline-block;
	border-radius: 5px;
	float: right;
}
.button:HOVER,.gbutton:HOVER{
transition-duration: 0.4s;
background-color: #3c4545;

box-shadow: 0 8px 16px 0 rgba(0, 0, 0, 0.2), 0 6px 20px 0
		rgba(0, 0, 0, 0.19);
}
.gbutton{
background-color: #450cf2;
border: none;
color: white;
padding: 8px 20px;
border-radius: 5px;
}
#testName{
padding: 7px 20px;
border: none;
font-size: 15px;
font-weight: bold;
}
</style>
<script src="./js/batchresult.js"></script>
<link rel="stylesheet" type="text/css" href="css/tablestyle.css">
</head>
<body>
	<center>
		<div class="form_box">

			Test Name : <select name="testName" id="testName">
				<%
					DAO ob = new DAO();
					ResultSet rs = ob.getAllTests();
					while (rs.next())
						out.println("<option value=" + rs.getString("TEST_ID") + ">" + rs.getString("TEST_NAME") + "</option>");
				%>

			</select> <br> <br> <input type="submit" value="Get Result"
				name="showuserreport" onclick="sendRequest()" class="gbutton">

		</div>
		<div class="report" id="report_card"></div>

	</center>
	<button class="backbutton button" onclick="goBack()" >Go Back</button>
</body>
</html>