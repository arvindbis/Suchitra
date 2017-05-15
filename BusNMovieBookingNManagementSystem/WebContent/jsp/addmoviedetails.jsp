<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@taglib uri="http://struts.apache.org/tags-logic" prefix="logic"%>
<%@taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<jsp:include page="header.jsp"></jsp:include>
<body id="moviebookingandmanagementsystem">
<marquee direction="right" scrollamount="15">
<img alt="moviepics" src="images/bahubali2.jpg">
<img alt="moviepics" src="images/googly.jpg">
<img alt="moviepics" src="images/dangal.jpg" id="moviepic">
<img alt="moviepics" src="images/dangal1.jpg">
<img alt="moviepics" src="images/bangaloredays.jpg">
<img alt="moviepics" src="images/karatekid.jpg">
<img alt="moviepics" src="images/snakeintheeagle'sshadow.jpg" id="moviepic">
</marquee>

	
	
	<font color="red"> <html:errors />
	</font>
	<h4 id="addmovieformheading">Add Movie Form</h4><br>
	<html:form  action="/newmoviedetails" styleId="addmovieform">
		
		<bean:message key="label.addmovie.moviename" /> : 
<html:text property="title" size="20" styleId="idfornewmoviename" />
		<br>
		<br>


		
		<bean:message key="label.addmovie.director" /> : 
<html:text property="director" styleId="idfornewmoviedirector"/>
		<br>
		<br>
		<br>
		<html:submit styleId="idfornewmoviesubmit">
			<bean:message key="label.addmovie.save" />
		</html:submit>
	</html:form>
</body>
</html>