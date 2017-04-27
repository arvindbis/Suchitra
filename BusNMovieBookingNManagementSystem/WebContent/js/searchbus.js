$(document).ready(function() {
	
	$("#viewSelectedBusForBookingform").hide();
	$("input[type='radio'][name='viewBus']").click(function() {
		$("#viewSelectedBusForBookingform").show();
		console.log("hi");
		var id = $(this).closest("tr");
		busNumber = id.find("td:eq(0)").text();
		busName=id.find("td:eq(1)").text();
		console.log(busNumber);
		$("input[name='busNumber']").val(busNumber);
		$("input[name='busName']").val(busName);
	})
	
});


