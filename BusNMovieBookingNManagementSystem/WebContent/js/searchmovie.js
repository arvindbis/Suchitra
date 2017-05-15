$(document).ready(function() {
$("#viewSelectedMovieForBookingform").hide();
	$("input[type='radio'][name='selectedmovie']").click(function() {
		$("#viewSelectedMovieForBookingform").show();
		console.log("hi");
		var id = $(this).closest("tr");
		title = id.find("td:eq(1)").text();
		movieId=id.find("td:eq(0)").text();
		console.log("title");
		console.log(title);
		console.log(movieId);
		$("input[name='title']").val(title);
		$("input[name='movieID']").val(movieId);
	})
});