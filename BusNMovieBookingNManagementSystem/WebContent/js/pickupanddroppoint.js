$(document).ready(function() {
	$("#passengerdetailsdiv").hide();
	$("#proceedbuttonforpassenger").hide();
	
	$("#proceedbuttonafterpickupndropptselection").click(function(){
		$("#passengerdetailsdiv").show();
		$("#proceedbuttonforpassenger").show();
	});
	
	$("#pickuppointtable").hide();
	$("#droppointtable").hide();
	
	$("#pickuppointbutton").click(function(){
		$("#droppointtable").hide();
		$("#pickuppointtable").show();
		$("input[type='radio'][name='radioButtonForuserSelectedPickPoint']").click(function() {
			
			
			var id = $(this).closest("tr");
			pickPoint = id.find("td:eq(0)").text();
			console.log("pickPoint");
			console.log(pickPoint);
			$("input[name='userSelectedPickPoint']").val(pickPoint);
		
		})
	});
	$("#droppointbutton").click(function(){
		$("#droppointtable").show();
		$("#pickuppointtable").hide();
		$("input[type='radio'][name='radioButtonForuserSelectedDropPoint']").click(function() {
			
			
			var id = $(this).closest("tr");
			dropPoint = id.find("td:eq(0)").text();
			console.log("dropPoint");
			console.log(dropPoint);
			$("input[name='userSelectedDropPoint']").val(dropPoint);
		
		})
	});
	
	
});
