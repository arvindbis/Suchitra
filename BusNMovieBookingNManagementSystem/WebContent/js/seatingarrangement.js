$(document).ready(function() {
	$("input[type='checkbox']").attr('checked', false);
		var seats=new Array();
		var noofSeats=0;
		var myform = $('#myform');
	iter = 0;

	$("input[type='checkbox']").change(function () {
		 if($(this).is(":checked")) {
		var selectedSeatNumber = $(this).closest("td");
		 seatNumber = selectedSeatNumber.context.id;
		 
		 console.log(selectedSeatNumber);
		  console.log(seatNumber);  
		
	     myform.find('tr').each(function(){
	         var trow = $(this);
	         
	         if(trow.index() === 0){
	             trow.append('<td></td><br>');
	         }else{
	             trow.append('<td><input type="text" id="'+seatNumber+'s" name="'+seatNumber+'s"/></td><br>');
	            var value="#"+seatNumber+"s";
	            console.log(value);
	            $(value).val(seatNumber);
	         }
	     });
	     iter += 1;
	}
		 else{
			
		        
			iter-=1;
			
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