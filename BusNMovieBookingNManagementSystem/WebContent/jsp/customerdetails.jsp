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

</head>
<jsp:include page="header.jsp"></jsp:include>
<body id="moviebookingandmanagementsystem">

	
		
	<html:form action="customerDetails" styleId="customerdetailsform">
   <%  Object value = request.getAttribute("numberOfSeatsformovie"); 
Object seats = request.getAttribute("seatNumbersformovie"); 
   int valueinaint=(Integer)value;
  
   %>
<div id="passengerdetailsdiv">
<%--  <%=value %> --%>
<%for(int iter=0;iter<valueinaint;iter++){		
if(iter==0){%>
<label>Primary Customer Name : </label><input type="text" name="customerName<%=iter%>" pattern="[a-zA-Z]*" title="Please enter characters" required="required"><br><br>
<label>Contact : </label><input type="text" name="customerContact" id="customerContact" pattern="[1-9][0-9]{9}" title="Ten digit mobile number" required><br><br><br><br><br><br>
<%}else{%>
<label>other Customer <%=iter %> : </label><input type="text" name="customerName<%=iter%>" id="cocustomername"><br><br>
 <%}}%>
 </div>
	
 <br>
<html:submit styleId="proceedbuttonforcustomer">Proceed</html:submit><br>
</html:form> 

</body>
</html>