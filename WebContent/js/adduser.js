var req;
function sendRequest(email) {

	if (window.XMLHttpRequest) {
		req = new XMLHttpRequest();
	} else if (window.ActiveXObject) {
		req = new ActiveXObject("Microsoft.XMLHTTP");
	}

	if (email != "") {
		var url = "Adduser?email=" + email;
		req.onreadystatechange = getResponse;
		req.open("GET", url, true);
		req.send(null);
	} else {
		document.getElementById("message").innerHTML = "";
	}
}

function getResponse() {
	if (req.readyState == 4) {
		if (req.status == 200) {
			document.getElementById("message").innerHTML = req.responseText;

		}
	}
}
function confirmMail() {
	var mail = document.getElementById("email").value;
	var amail = document.getElementById("aemail").value;

	if (amail != "") {
		if (mail == amail)
			document.getElementById("message").innerHTML = "Enter Different Alternative Mail ID";
		else
			document.getElementById("message").innerHTML = "";

	} else {
		document.getElementById("message").innerHTML = "";
	}

}
function fname(name) {

	if (name != "")
		if (name.includes(".")) {
			document.getElementById("message").innerHTML = "First Name Should Not Contain Special Charecters";
		} else {
			document.getElementById("message").innerHTML = "";
		}
}
function confirmPassword() {
	var password = document.getElementById("password").value;
	var cpassword = document.getElementById("cpassword").value;

	if (password != cpassword)
		document.getElementById("message").innerHTML = "Password Does Not Match";
}

function validatePassword() {
	var password = document.getElementById("password").value;
	
	var passw = /(?=.*\d)(?=.*[a-z])(?=.*[A-Z]).{8,}/;
	
	if (password != "")
		if (password.match(passw)) {
			document.getElementById("message").innerHTML = ""
			return true;
		} else {
			document.getElementById("message").innerHTML = "Possword Should no be week"
			return false;
		}
	else {
		document.getElementById("message").innerHTML = "";
	}
}
function valFun() {

	if (document.getElementById("message").value.length == 0)
		alert("empty");
	else
		alert("not empty");

	return false;
}
function goBack() {
	window.history.back();
}