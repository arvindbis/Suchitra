<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib prefix="html" uri="http://struts.apache.org/tags-html" %>
    <%@taglib prefix="bean" uri="http://struts.apache.org/tags-bean" %>
<!DOCTYPE html >
<html>
<head>
<link rel="stylesheet" type="text/css" href="css/stylesheet.css">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<script type="text/javascript" src="js/jquery-2.2.4.js"></script>
<script type="text/javascript" src="js/movieservices.js"></script>
</head>
<jsp:include page="header.jsp"></jsp:include>
<body id="moviebookingandmanagementsystem">
<font id="errormsg" color="white"> <html:errors />
	</font>
	<html:form styleId="moviedateenteringform" action="findmovie">
		<b>Enter the Date : </b>
		<input type="date" name="moviewatchingdate" required class="min-today"
			id="min" data-date-split-input="true">
		<html:submit value="Search" styleId="searchmovie"></html:submit>
		<br>
		<br>
	</html:form>

	<marquee direction="up" ><img alt="moviepics" src="images/bahubali.jpg">
<img alt="moviepics" src="images/bahubali2.jpg">
<img alt="moviepics" src="images/googly.jpg">
<img alt="moviepics" src="images/dangal.jpg" id="moviepic">
</marquee>
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