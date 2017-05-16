<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@taglib uri="http://struts.apache.org/tags-logic" prefix="logic"%>
<%@taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" type="text/css" href="css/stylesheet.css">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<jsp:include page="header.jsp"></jsp:include>
<body>

<font color="red"> <html:errors />
	</font>

	<html:form action="/registrationform" styleId="registrationform"> 

		<br />
		<br />
		<bean:message key="label.email" /> : 
<html:text property="emailAddress" size="20" />
		<br />
		<br />
		<bean:message key="label.pwd" /> : 
		<html:password property="pwd" size="20" styleId="registrationpassword"></html:password>
		<br />
		<br />
		<bean:message key="label.repwd" /> : 
		<html:password property="repwd" size="20"  styleId="rregistrationpassword"></html:password>
		<br />
		<br />
		 <html:submit styleId="registersubmitbutton">
			<bean:message key="label.user.button.submit" />
		</html:submit> 
</html:form>
	


	
</body>
</html>