<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@taglib uri="http://struts.apache.org/tags-logic" prefix="logic"%>
<%@taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" type="text/css" href="css/stylesheet.css">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<script type="text/javascript" src="js/jquery-2.2.4.js"></script>
<script type="text/javascript" src="js/disablebrowserbackbutton.js"></script>
</head>
 <jsp:include page="header.jsp"></jsp:include>
<body>
<br><br><br><br><br><br>

	<br>
	
	<font color="red"> <html:errors />
	</font>
	<h4 id="addbusformheading">Add Bus Form</h4><br>
	<html:form action="/newbusdetails" styleId="addbusform">
		<bean:message key="label.addbus.busname" /> : 
<html:text property="busName" size="20" styleId="idfornewbusname" />

		<br>
		<br>
		<bean:message key="label.addbus.busnumber" /> : 
<html:text property="busNumber" size="20" styleId="idfornewbusnumber" />
		<br>
		<br>


		<%-- <bean:message key="label.addbus.seat" /> : 
<html:text property="numberOfSeats" size="20" />
		<br>
		<br> --%>
		<bean:message key="label.addbus.bustype" /> : 
<html:select property="busType" styleId="idfornewbustype">
			<html:option value="A/C Seater">A/C Seater</html:option>
			<html:option value="Non A/C Seater">Non A/C Seater</html:option>
			
		</html:select>
		<br>
		<br>
		<br>
		<html:submit styleId="idfornewbussubmit">
			<bean:message key="label.addbus.save" />
		</html:submit>
	</html:form>
</body>
</html>