<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Author Question</title>

<link rel="stylesheet" type="text/css"
	href="css/authorquestionstyle.css">
<script>
	function goBack() {
		window.history.back();
	}
</script>

</head>
<body>
	<%
		String s = (String) request.getAttribute("uname");
		if (s == null) {
			RequestDispatcher rd = request.getRequestDispatcher("/index.jsp");
			rd.forward(request, response);
		}
	%>
	<div class="logout">

		<%=request.getAttribute("uname")%><br> <a href="index.jsp">Logout</a>
	</div>

	<div class="continar">
		<center>
			<h3>Question Details</h3>
		</center>
		<form action="AuthorQuestion" class="questionform" method="post">
			Title : <br>
			<input type="text" size="103%" name="title" required="" placeholder="Question Title"><br>
			<br>Domain : <br>
			<select class="domine" name="domine">
				<option value="string">String</option>
				<option value="algorithms">Algorithms</option>
				<option value="datastructures">Data Structures</option>
				<option value="mathematics">Mathematics</option>
			</select><br> <br> Description :<br>
			<textarea column width="80%" rows="6" cols="90" name="description"
				required="" placeholder="Description or Concept of problem"></textarea>
			<br> Constraints :<br>
			<textarea column width="80%" rows="4" cols="90" name="constraints"
				required="" placeholder="Constraints"></textarea>
			<br> Input Format :<br>
			<textarea column width="80%" rows="4" cols="90" name="input_format"
				required="" placeholder="Input Format or Pattern"></textarea>
			<br> Output Format :<br>
			<textarea column width="80%" rows="4" cols="90" name="output_format"
				required="" placeholder="Output Format or Pattern"></textarea>
			<br> Sample input :<br>
			<textarea column width="80%" rows="4" cols="90" name="sample_input"
				required="" placeholder="Sample Input To Be Displayed in Assessment Page"></textarea>
			<br> Sample output :<br>
			<textarea column width="80%" rows="4" cols="90" name="sample_output"
				required="" placeholder="Sample Output To Be Displayed in Assessment Page"></textarea>
			<br> Test Cases 1: <input type="number" min="1" max="10" name="ip1p"
				placeholder='Points' required=""> out of 10<br> <br> 
				Input:<br>
			<textarea  width="80%" rows="4" cols="90" name="inp1" required="" placeholder="Test Case 1 Input"></textarea>
			<br> Output:<br>
			<textarea  width="80%" rows="4" cols="90" name="op1" required="" placeholder="Test Case 1 Output"></textarea>

			<br> Test Cases 2: <input type="number" min="1" max="10" name="ip2p"
				placeholder='Points' required=""> out of 10<br> <br> 
				Input:<br>
			<textarea column width="80%" rows="4" cols="90" name="inp2" required="" placeholder="Test Case 2 Input"></textarea>
			<br> Output:<br>
			<textarea column width="80%" rows="4" cols="90" name="op2" required="" placeholder="Test Case 2 Output"></textarea>

			<br> Test Cases 3: <input type="number" min="1" max="10" name="ip3p"
				placeholder='Points' required=""> out of 10<br> <br>
				 Input:<br>
			<textarea column width="80%" rows="4" cols="90" name="inp3" required="" placeholder="Test Case 3 Input"></textarea>
			<br> Output:<br>
			<textarea column width="80%" rows="4" cols="90" name="op3" required="" placeholder="Test Case 3 Output"></textarea>

			<br> Test Cases 4: <input type="number" min="1" max="10" name="ip4p"
				placeholder='Points' required=""> out of 10<br> <br> 
				Input:<br>
			<textarea column width="80%" rows="4" cols="90" name="inp4" required="" placeholder="Test Case 4 Input"></textarea>
			<br> Output:<br>
			<textarea column width="80%" rows="4" cols="90" name="op4" required="" placeholder="Test Case 4 Output"></textarea>
			<div class='initialcode'>
				<br> Predefined Codings:<br> <br> Package Imports:<br>
				<textarea class="code" column width="80%" rows="4" cols="60"
					name="imports" required="" placeholder="Java Packages To Be Import"></textarea>
				<br> Main Method Defination:<br>
				<textarea class="code" column width="80%" rows="10" cols="60"
					name="main" required="">public static void main(String args[]){}
					</textarea>
				<br> User Method Prototype: <lable style="color:red;font-size:20px;">&nbsp; Method should be<i> static</i></lable><br>
				<textarea class="code" column width="80%" rows="2" cols="60"
					name="method" required="" placeholder="User Method Prototype"></textarea>  
			</div>
			<br> <input type="submit" class="button" value="Add">
			<button class="button back" onclick="goBack()">Go Back</button>

		</form>
	</div>
</body>
</html>