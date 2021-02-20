var req;

function sendRequest() {
	var username=document.getElementById("username").value;
	
	if (window.XMLHttpRequest) {
		req = new XMLHttpRequest();
	} else if (window.ActiveXObject)// for IE
	{
		req = new ActiveXObject("Microsoft.XMLHTTP");
	}
	
	var url = "IndividualResult?username=" + username;
	
	
	req.onreadystatechange = getResponse;
	req.open("GET", url, true);// send request to server
	req.send(null);
}

area
function getResponse() {
	if (req.readyState == 4)
	{
		if (req.status == 200) 
		{			
			document.getElementById("report_card").innerHTML = req.responseText;
			
		}
	}
}
function getExcelFile() {
	
	var htmltable = document.getElementById('tbl');
	var html = htmltable.outerHTML;
	window.open('data:application/vnd.ms-excel,' + encodeURIComponent(html));
}
function goBack() {
	window.history.back();
}