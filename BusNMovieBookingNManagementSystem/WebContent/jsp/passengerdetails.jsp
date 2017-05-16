<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="html" uri="http://struts.apache.org/tags-html"%>
<%@taglib prefix="bean" uri="http://struts.apache.org/tags-bean"%>
<%@taglib prefix="logic" uri="http://struts.apache.org/tags-logic"%>
<!DOCTYPE html >
<html>
<head>
<link rel="stylesheet" type="text/css" href="css/stylesheet.css">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
 <script type="text/javascript" src="js/jquery-2.2.4.js"></script>
<script type="text/javascript" src="js/pickupanddroppoint.js"></script> 
</head>
<jsp:include page="header.jsp"></jsp:include>
<body>
<button id="pickuppointbutton">Pick Up Points</button>
 
	
	<button id="droppointbutton">Drop Points</button><br><br>
	<table border="1"  id="pickuppointtable">
		<tr>
			<th>Locations</th>
			<th>Select </th>
			
		</tr>
		 
		 <logic:iterate id="busdetail" property="pickupPoints" name="businfoaddForm">
		 <tr>
		<td><bean:write name="busdetail" /></td>
		<td><input type="radio" name="radioButtonForuserSelectedPickPoint" ></td>
			</tr>
			</logic:iterate> 
	</table>
 <table border="1"  id="droppointtable">
		<tr>
			<th>Locations</th>
			<th>Select </th>
			
		</tr>
		 
		 <logic:iterate id="busdetail" property="droppingPoints" name="businfoaddForm">
		 <tr>
		<td><bean:write name="busdetail" /></td>
		<td><input type="radio" name="radioButtonForuserSelectedDropPoint" ></td>
			</tr>
			</logic:iterate> 
	</table>
	<br>
	 <button id="proceedbuttonafterpickupndropptselection">Proceed</button> 
		
	<html:form action="passengerDetails" styleId="passengerdetailsform">
   <%  Object value = request.getAttribute("numberOfSeats"); 
Object seats = request.getAttribute("seatNumbers"); 
   int valueinaint=(Integer)value;
  
   %>
<div id="passengerdetailsdiv">
<%-- <%=value %> --%>
<%for(int iter=0;iter<valueinaint;iter++){		
if(iter==0){%>
<label>Primary Passenger Name : </label><input type="text" name="passengerName<%=iter%>"  required ><br><br>
<label>Gender : </label><input type="text" name="passengerGender<%=iter%>" id="passengerGender" required><br><br>
<label>Age : </label><input type="text" name="passengerAge<%=iter%>" id="passengerAge" required><br><br>
<label>Contact : </label><input type="text" name="passengerContact" id="passengerContact" required pattern="[7-9][0-9]*" title="enter correct 10 digit number"><br><br><br><br><br><br>
<%}else{%>
<label>Co-Passenger <%=iter %> : </label><input type="text" name="passengerName<%=iter%>" id="copassengername"><br><br>
<label>Gender : </label><input type="text" name="passengerGender<%=iter%>" id="copassengerGender"><br><br>
<label>Age : </label><input type="text" name="passengerAge<%=iter%>" id="copassengerAge"><br><br><br>
 <%}}%>
 </div>
	<input type="hidden" name="userSelectedPickPoint"/>
	<input type="hidden" name="userSelectedDropPoint"/>
 <br>
<html:submit styleId="proceedbuttonforpassenger">Proceed</html:submit><br>
</html:form> 

</body>
</html>