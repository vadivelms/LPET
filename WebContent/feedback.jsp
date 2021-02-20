<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Feedback</title>
<style>
body {
	background-color: #eef5f7;
}

.form_contene {
	width: 50%;
	text-align: left;
	background-color: #dce1e3;
	padding: 20px;
	border-radius: 5px;
	font-size: 20px;
	text-transform:
}

.cmnts {
	resize: vertical;
}

.name, .cmnts {
	padding: 10px;
	border: none;
	border-radius: 5px;
	font-size: 20px;
}

.name {
	width: 40%;
}
.nextbtn {
margin-top:3%;
	border: 1px solid #382dec;
	font-size: 20px;
	background-color: #e2f1f6;
	padding: 10px 30px;
	width: 250px;
}

.nextbtn:HOVER {
	background-color: #382dec;
	color: white;
}
</style>
</head>
<body>
	<form action="Finish">
		<center>
			<h1>Feedback Form</h1>
			<div class="form_contene">

				Name : <input type="text" name="name" class="name"><br>
				<br> Email : <input type="email" name="email" class="name"><br>
				<br> Comments :<br>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				<textarea rows="5" cols="50" style="margin-top: 2px;" class="cmnts" name="comments"></textarea>
			</div>
			<input type="submit" value="Sumbit & Exit" class="nextbtn">
		</center>
	</form>

</body>
</html>