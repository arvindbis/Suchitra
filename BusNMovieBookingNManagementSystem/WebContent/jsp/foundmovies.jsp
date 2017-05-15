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
<title>Insert title here</title>
<script type="text/javascript" src="js/jquery-2.2.4.js"></script>
<script type="text/javascript" src="js/disablebrowserbackbutton.js"></script>
<script type="text/javascript" src="js/searchmovie.js"></script>
</head>
<body id="moviebookingandmanagementsystem">
<jsp:include page="header.jsp"></jsp:include>
<table border="1" id="foundmoviedetails">
		<tr>
			<th>Movie ID</th>
			<th>Movie Title</th>
			<th>Select the Movie</th>
		</tr>
 <logic:iterate id="moviedetail" property="foundmovies" name="movieForm">
		 <tr>
		<td><bean:write name="moviedetail" property="movieID"/></td>
		<td><bean:write name="moviedetail" property="title"/></td>
		<td><input type="radio" name="selectedmovie" ></td>
			</tr>
			</logic:iterate> 
			</table>
		<br><br>
		<html:form action="viewMovieSeats" styleId="viewSelectedMovieForBookingform">

		<table border="1" cellpadding="5" id="selectedmoviebox">
		<tr>
				<td>Movie Title</td>
				<td id="hiddenmovieID"><html:hidden property="movieID" /></td>
				<td><html:text property="title" readonly="true" styleId="selecetedmoviename"/></td>
			</tr>
			
		</table><br>
		<div id="showtimingselectiondiv">
		<p>Select the show timing</p>
		<select name="showtiming" id="showtiming">
  <option value="morning">Morning show</option>
  <option value="afternoon">Afternoon Show</option>
  <option value="evening">Evening show</option>
  
</select></div>
		<br><br>
		<input type="submit" value="View seat"  id="viewmovieseatbutton"/>
	</html:form>	
</body>
</html>