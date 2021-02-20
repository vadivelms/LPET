<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Admin Login</title>
<style>
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
}
.button:HOVER{
transition-duration: 0.4s;
background-color: #3c4545;

box-shadow: 0 8px 16px 0 rgba(0, 0, 0, 0.2), 0 6px 20px 0
		rgba(0, 0, 0, 0.19);
}
.logout {
	float: right;
}
.backbutton{
float: right;

}
#menubox{
width: 30%;
	margin: 0 auto;
	background: rgba(130, 130, 130, .3);
	padding: 20px 22px;		
	margin-top: 4%;
}
</style>
<script>
	document.oncontextmenu = function() {
		return false;
	};
	
</script>
</head>

<body>
	<center>



		<form action="Admin" method="post">
			<h1>Admin Page</h1>
			<div class="logout" >
				<input type="hidden" name="uname"
					value='<%=request.getAttribute("username")%>'>
				<%=request.getAttribute("username")%><br> <a href="index.jsp">Logout</a>
			</div>
			<div id="menubox">
				 <input type="submit" name="authorquestion"
					class="button" value="Author Question"><br> <br><input
					type="submit" name="addusers" class="button" value="Add User">
				<br><br> <input type="submit" name="createtest" class="button"
					value="Create Test"><br><br> <input type="submit"
					name="result" class="button" value="View Results">
					<br><br> <input type="submit"
					name="feedback" class="button" value="View Feedbacks">
			</div>
		</form>
	</center>
	
</body>

</html>