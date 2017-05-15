$(document).ready(function() {
	$("#UnavailableSeatIdentifier").css('background-color', 'grey');
	console.log("MOVIES");
	var Seats=$("input[type='hidden'] ").val();
	console.log(Seats);
	i=0;
	var existSeat=new Array();
	for(iter=0;iter<Seats;iter++){		
		var value = "seatss" + iter;
		console.log(value);
		existSeat[i] = $("input[type='hidden'][name='" + value + "']").val();
		coloringseat="#"+existSeat[i];
		$(coloringseat).css('background-color', 'grey');
		i++;
}
	var seats=new Array();
	var noofSeats=0;
	var myform = $('#myform');
	iter = 0;
	$("input[type='checkbox']").change(function () {
		 if($(this).is(":checked")) {
			 j=0;
			 var selectedSeatNumber = $(this).closest("td");
			 seatNumber = selectedSeatNumber.context.id;
		 
			  console.log(selectedSeatNumber);
		  	 console.log(seatNumber);  
		  	for(var iter1=0;iter1<Seats;iter1++){
				console.log("seat:"	+ existSeat[iter1]);
				if (seatNumber == existSeat[iter1]) {
					alert(existSeat[iter1]+" is Already booked\nAlready booked seats are\n"+existSeat);
					$(this).attr('checked', false);
			  }
		     }
			 if($(this).is(":checked")){
			 myform.find('tr').each(function(){
	         var trow = $(this);
	         console.log("this"+this);
	         if(trow.index() === 0){
	             trow.append('<td></td><br>');
	         }else{
	             trow.append('<td><input type="text" id="'+seatNumber+'s" name="'+seatNumber+'s"/></td><br>');
	             var value="#"+seatNumber+"s";
	             /*console.log(value);*/
	             $(value).val(seatNumber);
	          }
	         });
			 iter += 1;
			 }
		 }
		 else{
				if(iter>0) {
					iter-=1;
				}
				var selectedSeatNumber = $(this).closest("td");
				console.log(selectedSeatNumber);
				seatNumber = selectedSeatNumber.context.id;
				console.log("seatNumber");
				console.log(seatNumber);
				
				var values="#"+seatNumber+"s";
		        var vv= $(values).val();
		          
				$(values).remove();
				console.log(selectedSeatNumber);
				console.log(seatNumber);  
				console.log(iter); 
				console.log(values);
				console.log(vv);
			
			 }
		 $("#noofseatselectedbyuser").val(iter);
		 seats[noofSeats++]=seatNumber;
		 for (i = 0; i < noofSeats; i++) { 
			 console.log("seat "+i);
			 console.log(seats[i]);
		 }
	})
	
});