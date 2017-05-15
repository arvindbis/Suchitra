<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="html" uri="http://struts.apache.org/tags-html"%>
<%@taglib prefix="bean" uri="http://struts.apache.org/tags-bean"%>
<%@taglib prefix="logic" uri="http://struts.apache.org/tags-logic"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" type="text/css" href="css/stylesheet.css">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<script type="text/javascript" src="js/jquery-2.2.4.js"></script>
<script type="text/javascript" src="js/disablebrowserbackbutton.js"></script>
<script type="text/javascript" src="js/seatingarrangementformovie.js"></script>

</head>
<jsp:include page="header.jsp"></jsp:include>
<body id="moviebookingandmanagementsystem">
<p>Unavailable    <button id="UnavailableSeatIdentifier"></button></p>
<input type="hidden"  name="countofbookedSeats" value="${noofbookedseats}" /> 


<%int iter2=0;%>
  <c:forEach items="${boookedseats}" var="bean" >
          								
               <input type="hidden" name="seatss<%=iter2%>" value="<c:out value="${bean}" />">  
              
              <%iter2++;%>
       
        </c:forEach>
<table border="1" id="viewseat" >
<% int count=1;
for(int iter=1;iter<=10;iter++){%>
<tr>
<%for(int iter1=1;iter1<=10;iter1++){
String idfortd="s"+count;%>
	<td id=<%=idfortd%>><label> s<%=count%></label><br><input type="checkbox" value="None" id=<%=idfortd%> class="class" 
				name="s1" />
<%count++;}%>
</tr>
	
<%} %>
</table>
<html:form styleId="myform" action="movieseatBooking">

<p id="seatsheading">Selected Seats are</p>
	<table >
		
			<tr id="Row1" >
				<td class="space"></td>
			</tr>
			
			<tr id="Row2">
			</tr>
			
		</table>
		<p id="totalseatselectedheading">Total Seat Selected</p>
		<input type="text" name="noofseatselectedbyuser" id="noofseatselectedbyuser">
		<html:submit value="proceed" styleId="movieproceedbutton"></html:submit>
		
	</html:form>
</body>
</html>