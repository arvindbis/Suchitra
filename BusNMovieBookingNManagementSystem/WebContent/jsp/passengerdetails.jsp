<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="html" uri="http://struts.apache.org/tags-html"%>
<%@taglib prefix="bean" uri="http://struts.apache.org/tags-bean"%>
<%@taglib prefix="logic" uri="http://struts.apache.org/tags-logic"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
hey

		
	<html:form action="passengerDetails">
   <%  Object value = request.getAttribute("numberOfSeats"); 
Object seats = request.getAttribute("seatNumbers"); 
   int valueinaint=(Integer)value;
  
   %>

<%=value %>
<%for(int iter=0;iter<valueinaint;iter++){		
if(iter==0){%>
<label>Primary Passenger Name : </label><input type="text" name="passengerName<%=iter%>"  ><br><br>
<label>Gender : </label><input type="text" name="passengerGender<%=iter%>"><br><br>
<label>Age : </label><input type="text" name="passengerAge<%=iter%>"><br><br>
<label>Contact : </label><input type="text" name="passengerContact"><br><br><br><br><br><br>
<%}else{%>
<label>Co-Passenger <%=iter %> : </label><input type="text" name="passengerName<%=iter%>" ><br><br>
<label>Gender : </label><input type="text" name="passengerGender<%=iter%>"><br><br>
<label>Age : </label><input type="text" name="passengerAge<%=iter%>"><br><br><br><br>
 <%}}%>
<html:submit>Proceed</html:submit>
</html:form> 
</body>
</html>