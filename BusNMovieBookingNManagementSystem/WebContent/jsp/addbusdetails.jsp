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
</head>
<%-- <jsp:include page="header.jsp"></jsp:include> --%>
<body>
<ul>


<li id="headerdetails"><b id="mainheading">Bus and Movie Ticket Booking and Management System</b></li>

</ul>
<br><br><br><br><br><br>

	<br>
	<br>
	<font color="red"> <html:errors />
	</font>
	<html:form action="/newbusdetails">
		<bean:message key="label.addbus.busname" /> : 
<html:text property="busName" size="20" />

		<br>
		<br>
		<bean:message key="label.addbus.busnumber" /> : 
<html:text property="busNumber" size="20" />
		<br>
		<br>


		<%-- <bean:message key="label.addbus.seat" /> : 
<html:text property="numberOfSeats" size="20" />
		<br>
		<br> --%>
		<bean:message key="label.addbus.bustype" /> : 
<html:select property="busType">
			<html:option value="A/c Seater">A/c Seater</html:option>
			<html:option value="Non A/c Seater">Non A/c Seater</html:option>
			
		</html:select>
		<br>
		<br>
		<html:submit>
			<bean:message key="label.addbus.save" />
		</html:submit>
	</html:form>
</body>
</html>