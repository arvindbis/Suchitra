<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib prefix="html" uri="http://struts.apache.org/tags-html" %>
    <%@taglib prefix="bean" uri="http://struts.apache.org/tags-bean" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@taglib prefix="html" uri="http://struts.apache.org/tags-html"%>
<html>
<head>
<link rel="stylesheet" type="text/css" href="css/stylesheet.css">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<script type="text/javascript" src="js/jquery-2.2.4.js"></script>
<script type="text/javascript" src="js/disablebrowserbackbutton.js"></script>
</head>
<jsp:include page="header.jsp"></jsp:include>
<body>
<p id="greet">Welcome Admin!....           your emailId : <%=request.getSession().getAttribute("username")%></p>
<br><br><br>
<ul > 
<li id="services"><html:link action="/busdetails" ><img alt="busServices" src="images/busimage.jpg"></html:link><br><br></li>
<li id="services"><html:link action="/moviedetails" ><img alt="movieServices" src="images/movieimage.jpg"></html:link><br><br></li>
</ul>
<ul>
<li id="capsrvices"><html:link action="/busdetails" >Bus Services</html:link></li>
<li id="capsrvices" class="movieServiceCaption"><html:link action="/moviedetails" >Movie Services</html:link></li>
</ul>
</body>
</html>