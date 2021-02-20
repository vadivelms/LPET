<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>${title}</title>
<style>

h2
{
color: red;
}
body {
	background-color: #eef5f7;
}

</style>
<script>
	function goBack() {
		window.history.back();
	}
</script>
</head>
<body>
<h1>Response Page </h1> 
<h2>${message}</h2>
<button class="button back" onclick="goBack()">Go Back</button>

</body>
</html>