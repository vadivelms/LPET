function confirmTest()
{
	var testName=document.getElementByclass(testname);
	var testDuration=document.getElementByclass(duration);
	confirm(testName+"\n"+testDuration);
}

function goBack() {
	window.history.back();
}
