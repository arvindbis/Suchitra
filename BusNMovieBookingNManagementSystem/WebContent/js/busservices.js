$(document).ready(function() { 
	/*
	function preventBack(){window.history.forward();}
    setTimeout("preventBack()", 0);
    window.onunload=function(){null};
    
	
	window.location.hash="no-back-button";
	window.location.hash="Again-No-back-button";//again because google chrome don't insert first hash into history
	window.onhashchange=function(){window.location.hash="no-back-button";}
	*/
	$("#deletebusform").hide();
	$("#editebusform").hide();

	$("input[type='radio'][name='deletebusinfo']").change(function() {
		$("#editebusform").hide();
		var radio = $(this).closest("tr");
		$("#deletebusform").show();
		
		busNumber = radio.find("td:eq(1)").text();
		
		console.log(busNumber);
		$("input[name='busNumber']").val(busNumber);
		
	})
	$("input[type='radio'][name='editbusinfo']").change(function() {
		$("#deletebusform").hide();
		var radio = $(this).closest("tr");
		$("#editebusform").show();
		
		busNumber = radio.find("td:eq(1)").text();
		busName=radio.find("td:eq(0)").text();
		busType=radio.find("td:eq(3)").text();
		seats=40;
		console.log(busNumber);
		console.log(busName);
		console.log(busType);
		console.log(seats);
		
		$("input[name='busNumber']").val(busNumber);
		$("input[name='busName']").val(busName);
		$("input[name='busType']").val(busType);
	
		$("input[name='numberOfSeats']").val(seats);
		
	})
});

