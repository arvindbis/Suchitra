<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="html" uri="http://struts.apache.org/tags-html"%>
<%@taglib prefix="bean" uri="http://struts.apache.org/tags-bean"%>
<%@taglib prefix="logic" uri="http://struts.apache.org/tags-logic"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page import ="java.util.*" %>
 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" type="text/css" href="css/stylesheet.css">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<script type="text/javascript" src="js/jquery-2.2.4.js"></script>
<script type="text/javascript" src="js/disablebrowserbackbutton.js"></script>
<script type="text/javascript" src="js/seatingarrangement.js"></script>
</head>
<jsp:include page="header.jsp"></jsp:include>
<body>
	<!-- <table border="1" cellpadding="10">
		<tr>
			<th>Female Seats</th>
			<td></td>
		</tr>
		<tr>
			<th>Unavailable</th>
			<td></td>
		</tr>
	</table> -->
	<p>Female Seats    <button id="femaleSeatIdentifier"></button></p>
	<p>Unavailable    <button id="UnavailableSeatIdentifier"></button></p>
<form >
<input type="hidden"  name="countofFemaleSeats" value="${totalSeats}" /> 
<%int iter=0;%>
<c:forEach items="${femaleSeats}" var="bean" >
          								
               <input type="hidden" name="seatss<%=iter%>" value="<c:out value="${bean}" />">  
              <input type="hidden" name="females<%=iter%>" value="<c:out value="${bean}" />"> 
              <%iter++;%>
       
        </c:forEach>
        <c:forEach items="${maleSeats}" var="bean" >
          								
               <input type="hidden" name="seatss<%=iter%>" value="<c:out value="${bean}" />">  
              
              <%iter++;%>
       
        </c:forEach>
  </form>      
        
        
	<table border="1" id="viewseat" >
		

		<tr>
			<td id="s1"><label> s1</label><br><input type="checkbox" value="None" id="s1" class="class" 
				name="s1" /></td>
			<td id="s5"><label> s5</label><br><input type="checkbox" value="None" id="s5" class="class"
				name="s5" /></td>
			<td id="s9"><label> s9</label><br><input type="checkbox" value="None" id="s9" class="class"
				name="check" /></td>
			<td id="s13"><label> s13</label><br><input type="checkbox" value="None" id="s13" class="class"
				name="check" /></td>
			<td id="s17"><label> s17</label><br><input type="checkbox" value="None" id="s17" class="class"
				name="check" /></td>
			<td id="s21"><label> s21</label><br><input type="checkbox" value="None" id="s21" class="class"
				name="check" /></td>
			<td id="s25"><label> s25</label><br><input type="checkbox" value="None" id="s25" class="class"
				name="check" /></td>
			<td id="s29"><label> s29</label><br><input type="checkbox" value="None" id="s29" class="class"
				name="check" /></td>
			<td id="s33"><label> s33</label><br><input type="checkbox" value="None" id="s33" class="class"
				name="check" /></td>
			<td id="s37"><label id="s40"> s37</label><br><input type="checkbox" value="None" id="s37" class="class"
				name="check" /></td>
		</tr>

		


		<tr>
			<td id="s2"><label> s2</label><br><input type="checkbox" value="None" id="s2" class="class"
				name="check" /></td>
			<td id="s6"><label> s6</label><br><input type="checkbox" value="None" id="s6" class="fg"
				name="s6" /></td>
			<td id="s10"><label> s10</label><br><input type="checkbox" value="None" id="s10" class="class"
				name="check" /></td>
			<td id="s14"><label> s14</label><br><input type="checkbox" value="None" id="s14" class="class"
				name="check" /></td>
			<td id="s18"><label> s18</label><br><input type="checkbox" value="None" id="s18" class="class"
				name="check" /></td>
			<td id="s22"><label> s22</label><br><input type="checkbox" value="None" id="s22" class="class"
				name="check" /></td>
			<td id="s26"><label> s26</label><br><input type="checkbox" value="None" id="s26" class="class"
				name="check" /></td>
			<td id="s30"><label> s30</label><br><input type="checkbox" value="None" id="s30" class="class"
				name="check" /></td>
			<td id="s34"><label> s34</label><br><input type="checkbox" value="None" id="s34" class="class"
				name="check" /></td>
			<td id="s38"><label> s38</label><br><input type="checkbox" value="None" id="s38" class="class"
				name="check" /></td>
		</tr>
		<tr bordercolor="white">
			<td colspan="10" height="20pt"></td>
		</tr>
		


		<tr>
			<td id="s3"><label> s3</label><br><input type="checkbox" value="None" id="s3"
				name="check" /></td>
			<td id="s7"><label> s7</label><br><input type="checkbox" value="None" id="s7"
				name="check" /></td>
			<td id="s11"><label> s11</label><br><input type="checkbox" value="None" id="s11"
				name="check" /></td>
			<td id="s15"><label> s15</label><br><input type="checkbox" value="None" id="s15"
				name="check" /></td>
			<td id="s19"><label> s19</label><br><input type="checkbox" value="None" id="s19"
				name="check" /></td>
			<td id="s23"><label> s23</label><br><input type="checkbox" value="None" id="s23"
				name="check" /></td>
			<td id="s27"><label> s27</label><br><input type="checkbox" value="None" id="s27"
				name="check" /></td>
			<td id="s31"><label> s31</label><br><input type="checkbox" value="None" id="s31"
				name="check" /></td>
			<td id="s35"><label> s35</label><br><input type="checkbox" value="None" id="s35"
				name="check" /></td>
			<td id="s39"><label> s39</label><br><input type="checkbox" value="None" id="s39"
				name="check" /></td>
		</tr>

		
		


		<tr>
			<td id="s4"><label> s4</label><br><input type="checkbox" value="None" id="s4"
				name="check" /></td>
			<td id="s8"><label> s8</label><br><input type="checkbox" value="None" id="s8"
				name="check" /></td>
			<td id="s12"><label> s12</label><br><input type="checkbox" value="None" id="s12"
				name="check" /></td>
			<td id="s16"><label> s16</label><br><input type="checkbox" value="None" id="s16"
				name="check" /></td>
			<td id="s20"><label> s20</label><br><input type="checkbox" value="None" id="s20"
				name="check" /></td>
			<td id="s24"><label> s24</label><br><input type="checkbox" value="None" id="s24"
				name="check" /></td>
			<td id="s28"><label> s28</label><br><input type="checkbox" value="None" id="s28"
				name="check" /></td>
			<td id="s32"><label> s32</label><br><input type="checkbox" value="None" id="s32"
				name="check" /></td>
			<td id="s36"><label> s36</label><br><input type="checkbox" value="None" id="s36"
				name="check" /></td>
			<td id="s40"><label> s40</label><br><input type="checkbox" value="None" id="s40"
				name="check" /></td>
		</tr>

	</table>
	<%-- <p>
	<%=  request.getAttribute("femaleSeats")  %>
</p> --%>


<html:form styleId="myform" action="seatBooking">

<p id="seatsheading">Selected Seats are</p>
	<table id="blacklistgrid">
		
			<tr id="Row1" >
				<td class="space"></td>
			</tr>
			
			<tr id="Row2">
			</tr>
			
		</table>
		<p id="totalseatselectedheading">Total Seat Selected</p>
		<input type="text" name="noofseatselectedbyuser" id="noofseatselectedbyuser">
		<html:submit value="proceed" styleId="proceedbutton"></html:submit>
	</html:form>
</body>
</html>