<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="html" uri="http://struts.apache.org/tags-html" %>
    <%@taglib prefix="bean" uri="http://struts.apache.org/tags-bean"%>
<%@taglib prefix="logic" uri="http://struts.apache.org/tags-logic"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" type="text/css" href="css/stylesheet.css">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">


<title>Bus Details Page</title>
<script type="text/javascript" src="js/jquery-2.2.4.js"></script>
<script type="text/javascript" src="js/busservices.js"></script>
</head>
<jsp:include page="header.jsp"></jsp:include>
<body>
<html:link action="/addbusdetails" > <button id="addBusButton">Add New Bus</button></html:link><br><br>
<table border="1" id="adminsidebusdetails">
		<tr>
			<th>Bus Name</th>
			<th>Bus Number</th>
			<th>Number of seats</th>
			<th>Bus Type</th>
			<th>Delete</th>
			<th>Edit</th>
		</tr>
		
		 <logic:iterate id="busdetail" property="list" name="businfoaddForm">
		 <tr  >
		<td><bean:write name="busdetail" property="busNumber"/></td>
		<td><bean:write name="busdetail" property="busName"/></td>
		<td><bean:write name="busdetail" property="numberOfSeats"/></td>
		<td><bean:write name="busdetail" property="busType"/></td>
		<td><input type="radio" name="deletebusinfo" ></td>
		 <td><input type="radio" name="editbusinfo"></td> 
		
			</tr>
			</logic:iterate> 
	</table>

	<br><br>
	<html:form action="deletebusaction" styleId="deletebusform">

		<table border="1" cellpadding="5">
			<tr>
				<td>Bus Number</td>
				<td><html:text property="busNumber" readonly="true" /></td>
			</tr>
		</table>
		<br>
		<input type="submit" value="delete" class="submits" id="deletebuutton"/>
	</html:form>
	
	
	<!-- EDIT BUS INFORMATION FORM -->
	<html:form action="editbusdetails"  styleId="editebusform">
			<h3 id="buseditformheading">Bus Edit Form:</h3>
			<table border="1" cellpadding="5">
				
				<tr>
					<td>Bus Name</td>
					<td><html:text property="busName" /></td>
				</tr>
				<tr>
					<td>Bus Number</td>
					<td><html:text property="busNumber" readonly="true" /></td>
				</tr>
				
				<tr>
					<td>Seats</td>
					<td><html:text property="numberOfSeats" /></td>
				</tr>
				<tr>
					<td>Bus Type</td>
					<td><html:select property="busType">
							
							<html:option value="AC Seater">AC Seater</html:option>
							<html:option value="Non AC Seater">Non AC Seater</html:option>
						</html:select></td>
				</tr>
			</table>
			<br>
			<input type="submit" value="update" class="submits" id="editbuutton"/>
	 </html:form> 


	
</body>
</html>