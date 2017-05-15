<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib prefix="html" uri="http://struts.apache.org/tags-html" %>
    <%@taglib prefix="bean" uri="http://struts.apache.org/tags-bean" %>
<%@taglib prefix="logic" uri="http://struts.apache.org/tags-logic"%>

<!DOCTYPE html >
<html>
<head>
<link rel="stylesheet" type="text/css" href="css/stylesheet.css">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<script type="text/javascript" src="js/jquery-2.2.4.js"></script>
<script type="text/javascript" src="js/disablebrowserbackbutton.js"></script>
<script type="text/javascript" src="js/movieservices.js"></script></head>
<jsp:include page="header.jsp"></jsp:include>

<body id="moviebookingandmanagementsystem">
<marquee direction="up" ><img alt="moviepics" src="images/bahubali.jpg">
<img alt="moviepics" src="images/bahubali2.jpg">
<img alt="moviepics" src="images/googly.jpg">
<img alt="moviepics" src="images/dangal.jpg" id="moviepic">
</marquee>
 <html:link action="/addmoviedetails"> <button id="addMovieButton">Add New Movie</button></html:link><br><br> 
<table border="1" id="adminmoviedetails">
		<tr>
			<th>movie ID</th>
			<th>movie Title</th>
			<th>Director</th>
			<th>Delete</th>
			<th>Edit</th>
		</tr>
		
		 <logic:iterate id="moviedetail" property="list" name="movieForm">
		 <tr  >
		<td><bean:write name="moviedetail" property="movieID"/></td>
		<td><bean:write name="moviedetail" property="title"/></td>
		<td><bean:write name="moviedetail" property="director"/></td>
		<td><input type="radio" name="deletemovieinfo" ></td>
		 <td><input type="radio" name="editmovieinfo"></td> 
			</tr>
			</logic:iterate> 
	</table>

	<br><br>
	<html:form action="deletemovieaction" styleId="deletemovieform">

		<table border="1" cellpadding="5">
			<tr>
				<td>Movie Id</td>
				<td><html:text property="movieID" readonly="true" /></td>
			</tr>
		</table>
		<br>
		<input type="submit" value="delete" class="submits" id="deletemoviebutton"/>
	</html:form>
	
	
	<!-- EDIT BUS INFORMATION FORM -->
	<html:form action="editmoviedetails"  styleId="editmovieform">
			<h3 id="movieeditformheading">Movie Edit Form:</h3>
			<table border="1" cellpadding="5">
				
				<tr>
					<td>Movie Id</td>
					<td><html:text property="movieID" readonly="true"/></td>
				</tr>
				<tr>
					<td>Movie Title</td>
					<td><html:text property="title"  /></td>
				</tr>
				
				<tr>
					<td>Director</td>
					<td><html:text property="director" /></td>
				</tr>
				
			</table>
			<br>
			<input type="submit" value="update" class="submits" id="editmoviebutton"/>
	 </html:form> 

	
<marquee direction="right" scrollamount="15">
<img alt="moviepics" src="images/bahubali2.jpg">
<img alt="moviepics" src="images/googly.jpg">
<img alt="moviepics" src="images/dangal.jpg" id="moviepic">
<img alt="moviepics" src="images/dangal1.jpg">
<img alt="moviepics" src="images/bangaloredays.jpg">
<img alt="moviepics" src="images/karatekid.jpg">
<img alt="moviepics" src="images/snakeintheeagle'sshadow.jpg" id="moviepic">
</marquee>
</body>
</html>