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
 <jsp:include page="header.jsp"></jsp:include>
<body>

	<br>
	<br>
	<font color="red"> <html:errors />
	</font>
	<html:form action="/newbusdetails">
		<bean:message key="label.addbus.busname" /> : 
<html:text property="newbusname" size="20" />
		<br>
		<br>
		<bean:message key="label.addbus.busnumber" /> : 
<html:text property="newbusnumber" size="20" />
		<br>
		<br>
		<bean:message key="label.addbus.source" /> : 
<html:text property="fromAddress" size="20" />
		<br>
		<br>
		<bean:message key="label.addbus.destination" /> : 
<html:text property="toAddress" size="20" />
		<br>
		<br>
		<bean:message key="label.addbus.starttime" /> : 
<html:text property="departureTime" size="20" />
		<br>
		<br>
		<bean:message key="label.addbus.reachtime" /> : 
<html:text property="arrivalTime" size="20" />
		<br>
		<br>
		<html:submit>
			<bean:message key="label.addbus.save" />
		</html:submit>
	</html:form>
</body>
</html>