<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Test</title>
<link rel="stylesheet" type="text/css" href="css/teststyle.css">
<script src="./js/testjs.js"></script>
<script>
	document.oncontextmenu = function() {
		return false;
	};
</script>
</head>
<body >
	<div class="question1_div" id="q1div">
		<form action="Compiler" class="sourcecodeform" method="post"
			id="testform">
			<div class="navigations">
				<input type="hidden" name="testName" value="<%=request.getAttribute("testName")%>" id="testName">
				<lable class="testname"><%=request.getAttribute("testName")%></lable>
				<%=request.getAttribute("username")%>
				<!-- <input type="text" id="timer" readonly="readonly">  -->
				<input type="submit" name="finish" value="Finish Test" class="finifhbutn">
			</div>
			<input type="hidden" name="testId" id="testId"	value="<%=request.getAttribute("testId")%>"> 
			<input type="hidden" name="questionId" id="questionId"	value="<%=request.getAttribute("questionId")%>">
			<div class="header">

				<input type="hidden" value="<%=request.getAttribute("username")%>"	name="username" id="username">
			</div>
			<table class="pagetable">
				<col width="600">
				<col width="750">
				<tr>
					<td rowspan="3" valign="top">
						<div class="question">
							<h3>

								<%=request.getAttribute("title")%>
								<input type="hidden" value="<%=request.getAttribute("title")%>"
									name="title">
							</h3>
							<h4>Problem :</h4>
							<br><%=request.getAttribute("desc")%>
							<input type="hidden" value="<%=request.getAttribute("desc")%>"
								name="desc">
							<h4>Constraints :</h4>
							<br><%=request.getAttribute("constraints")%>
							<input type="hidden"
								value="<%=request.getAttribute("constraints")%>"
								name="constraints">
							<h4>Input Format:</h4>
							<br><%=request.getAttribute("i_f")%>
							<input type="hidden" value="<%=request.getAttribute("i_f")%>"
								name="i_f">
							<h4>Output Format:</h4>
							<br><%=request.getAttribute("o_f")%>
							<input type="hidden" value="<%=request.getAttribute("o_f")%>"
								name="o_f">
							<h4>Sample Input :</h4>
							<br><%=request.getAttribute("s_i")%>
							<input type="hidden" value="<%=request.getAttribute("s_i")%>"
								name="s_i">
							<h4>Sample Output :</h4>
							<br><%=request.getAttribute("s_o")%>
							<input type="hidden" value="<%=request.getAttribute("s_o")%>"
								name="s_o">
						</div>
					</td>

					<td class="compiler" height="" valign="top">
						<div class="compilerdiv">


							<h3>Compiler :</h3>

							<input type="hidden" name="filename"
								value='<%=request.getAttribute("filename")%>' id="filename">
							<%=request.getAttribute("filename")%>
							<textarea rows="20" cols="100" name="sourcecode"
								class="code_window" id="sourcecode">${coding}</textarea>
							<table class="buttontable">
								<tr>
									<td>
									<input type="button" name="compile_run"	value="COMPILE & RUN" class="crbutton" id="compile_run" onclick="crbtn(this)">
									</td>
									<td><input type="button" name="submit" value="SUBMIT"
										class="submitbutton" id="submitbutton" onclick="crbtn(this)"></td>
								</tr>
							</table>

						</div>
					</td>
				</tr>
				<tr class="userip_window">

					<td height="50" valign="top"><input type="checkbox"
						onchange="usemyip(this)"> Use My Inputs <br>
						<div class="userip" id="userip_div"></div></td>
				</tr>
				<tr class="output_window">

					<td height="50" valign="top" id="console_column"><h3>Console :</h3> <textarea
							rows="5" cols="100" name="output" id="console" readonly="" class="console">${output}</textarea></td>
				</tr>
				

			</table>
		</form>
	</div>
</body>
</html>