/**
 * 
 */
function usemyip(element) {
	if (element.checked) {
		checked();
	} else if (!element.checked) {
		notchecked();
	}
};

function checked() {

	var txarea = document.createElement("textarea");
	txarea.setAttribute("class", "userip");
	txarea.setAttribute("id", "userip");
	txarea.setAttribute("name", "userip");
	txarea.cols = "100";
	var div = document.getElementById("userip_div");
	div.appendChild(txarea);
};

function notchecked() {
	var ele = document.getElementById("userip");
	ele.remove();

};

var req;

function crbtn(btn) {

	if (window.XMLHttpRequest) {
		req = new XMLHttpRequest();
	} else if (window.ActiveXObject) {
		req = new ActiveXObject("Microsoft.XMLHTTP");
	}
	var btn = btn.id;
	var console = document.getElementById("console");
	console.focus();
	console.value = "Compiling.....";
	var username = document.getElementById("username").value;
	var testId = document.getElementById("testId").value;

	var questionId = document.getElementById("questionId").value;

	var filename = document.getElementById("filename").value;

	var sourcecode = document.getElementById("sourcecode").value;
	
	alert(sourcecode);
	var userip = document.getElementById("userip");
	if (userip != null)
		userip = document.getElementById("userip").value;

	var url = "Compiler?username=" + username + "&testId=" + testId
			+ "&questionId=" + questionId + "&userip=" + userip + "&filename="
			+ filename + "&sourcecode=" + sourcecode + "&btn=" + btn;
	req.onreadystatechange = crbtnGetResponse;
	req.open("GET", url, true);
	req.send(null);
}

function crbtnGetResponse() {
	if (req.readyState == 4) {
		if (req.status == 200) {
			var console = document.getElementById("console");
			console.value = req.responseText;

		}
	}
}