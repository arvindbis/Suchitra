<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html >
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<%@taglib prefix="html" uri="http://struts.apache.org/tags-html"%>
<link rel="stylesheet" type="text/css" href="css/stylesheet.css">
<title>Insert title here</title>
<script type="text/javascript" src="js/jquery-2.2.4.js"></script>
<script type="text/javascript" src="js/disablebrowserbackbutton.js"></script>
<script type="text/javascript" src="js/searchbus.js"></script>
</head>
<jsp:include page="header.jsp"></jsp:include>
<body>
<html:form action="busSearch" styleId="busbookingform">

		<table border="1" cellpadding="5">
			<tr>
				<td>From</td>
				<td><html:text property="fromAddress" /></td>
				
			</tr>
			<tr>
				<td>To</td>
				<td><html:text property="toAddress" /></td>
			</tr>
			 <tr>
			 
			 
				<td>Date</td>
				<td><input type="date" name="traveldate" required class="min-today" id="min" data-date-split-input="true"/></td>
			</tr>
		</table>
		<br>
		<input type="submit" value="search" id="bussearchbutton" />
	</html:form>

</body>
</html>