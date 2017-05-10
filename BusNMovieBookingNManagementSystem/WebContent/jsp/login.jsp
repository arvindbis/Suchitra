<%@taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@taglib uri="http://struts.apache.org/tags-logic" prefix="logic"%>
<%@taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<html>
<head>
<link rel="stylesheet" type="text/css" href="css/stylesheet.css">
<script type="text/javascript" src="js/jquery-2.2.4.js"></script>
<script type="text/javascript" src="js/disablebrowserbackbutton.js"></script>
</head>
<body>
<br>
<ul>


<li id="headerdetails"><b id="mainheading">Bus and Movie Ticket Booking and Management System</b></li>

</ul>
<br><br><br><br><br><br>
	<font id="errormsg" color="white"> <html:errors />
	</font>

	<html:form action="/login" styleId="loginform">

		<br />
		<br />
		<bean:message key="label.user.email" /> : 
<html:text property="email" size="20" />
		<br />
		<br />
		<bean:message key="label.user.password" /> : 
		<html:password property="password" size="20" styleId="psid"></html:password>
		<br />
		<br />
		<html:submit styleId="loginsubmitbutton">
			<bean:message key="label.user.button.submit" />
		</html:submit> 

	 </html:form>
	<html:link action="/registration" styleId="registerbutton">Register</html:link>
	<br>

</body>
<%-- <jsp:include page="footer.jsp"></ jsp:include> --%>
</html>

