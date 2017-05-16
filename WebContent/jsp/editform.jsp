<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    

   <%@taglib prefix="bean" uri="http://struts.apache.org/tags-bean"%>
    <%@taglib prefix="html" uri="http://struts.apache.org/tags-html"%> 
     <%@taglib prefix="logic" uri="http://struts.apache.org/tags-logic"%>
    <%@taglib prefix="nested" uri="http://struts.apache.org/tags-nested"%> 
     <%@taglib prefix="tiles" uri="http://struts.apache.org/tags-tiles"%>
   
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" type="text/css" href="css/stylesheet.css">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<!-- <script type="text/javascript" src="js/jquery-2.2.4.js"></script>
<script type="text/javascript" src="js/editbusdetails.js"></script> -->
<title>Insert title here</title>
</head>
<jsp:include page="header.jsp"></jsp:include>
<body>
edit form

<%-- <table border="1">
		<tr>
			<td>Bus Number</td>
			<td ><bean:write name="busform" property="busnumber"/></td>
		</tr>
</table> --%>
<font color="red"> <html:errors />
	</font>
	<html:form action="/updatebusdetails">
		<bean:message key="label.addbus.busname" /> : 
<html:text property="busname" size="20" />
		<br>
		<br>
		<bean:message key="label.addbus.busnumber" /> : 
<html:text property="busnumber" size="20" />
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
