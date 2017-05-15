$(document).ready(function() {
	
	$(function(){
	    $('[type="date"].min-today').prop('min', function(){
	        return new Date().toJSON().split('T')[0];
	    });
	});
	
	$("#deletemovieform").hide();
	$("#editmovieform").hide();

	$("input[type='radio'][name='deletemovieinfo']").change(function() {
		$("#editmovieform").hide();
		var radio = $(this).closest("tr");
		$("#deletemovieform").show();
		
		movieID = radio.find("td:eq(0)").text();
		
		console.log(movieID);
		$("input[name='movieID']").val(movieID);
		
	})
	$("input[type='radio'][name='editmovieinfo']").change(function() {
		$("#deletemovieform").hide();
		var radio = $(this).closest("tr");
		$("#editmovieform").show();
		
		movieId = radio.find("td:eq(0)").text();
		title=radio.find("td:eq(1)").text();
		director=radio.find("td:eq(2)").text();
		
		
		
		$("input[name='movieID']").val(movieId);
		$("input[name='title']").val(title);
		$("input[name='director']").val(director);
	
		
		
	})
	
});