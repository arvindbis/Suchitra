<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html >
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<%@taglib prefix="html" uri="http://struts.apache.org/tags-html"%>

<title>Insert title here</title>
</head>
<body>
<!-- <form action="busSearch" method="post">
From:<input type="text" name="fromAddress" />
To:<input type="text" name="toAddress" />
Date:<input type="date" name="traveldate" />
<input type="submit" value="search">
</form> -->

<html:form action="busSearch" >

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
				<td><input type="date" name="traveldate" required/></td>
			</tr>
		</table>
		<input type="submit" value="search"  />
	</html:form>

</body>
</html>