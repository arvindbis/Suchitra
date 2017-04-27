<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@ taglib prefix="html" uri="http://struts.apache.org/tags-html" %>
    <%@taglib prefix="bean" uri="http://struts.apache.org/tags-bean"%>
<%@taglib prefix="logic" uri="http://struts.apache.org/tags-logic"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<script type="text/javascript" src="js/jquery-2.2.4.js"></script>
<script type="text/javascript" src="js/searchbus.js"></script>
</head>
<body>
<table border="1" id="viewseat" >
		<tr>
			<th>Bus Name</th>
			<th>Bus Number</th>
			<th>Number of seats</th>
			<th>Bus Type</th>
			<th>Select Bus</th>
			
		</tr>
		 
		 <logic:iterate id="busdetail" property="foundbusdetails" name="businfoaddForm">
		 <tr>
		<td><bean:write name="busdetail" property="busNumber"/></td>
		<td><bean:write name="busdetail" property="busName"/></td>
		<td><bean:write name="busdetail" property="numberOfSeats"/></td>
		<td><bean:write name="busdetail" property="busType"/></td>
		<td><input type="radio" name="viewBus" ></td>
			</tr>
			</logic:iterate> 
	</table>
	<br><br>
		<html:form action="viewSeat" styleId="viewSelectedBusForBookingform">

		<table border="1" cellpadding="5">
		<tr>
				<td>Bus Name</td>
				<td><html:text property="busName" readonly="true" /></td>
			</tr>
			<tr>
				<td>Bus Number</td>
				<td><html:text property="busNumber" readonly="true" /></td>
			</tr>
		</table>
		<input type="submit" value="View seat"  />
	</html:form>
</body>
</html>