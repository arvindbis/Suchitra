<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="html" uri="http://struts.apache.org/tags-html"%>
<%@taglib prefix="bean" uri="http://struts.apache.org/tags-bean"%>
<%@taglib prefix="logic" uri="http://struts.apache.org/tags-logic"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page import ="java.util.*" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<script type="text/javascript" src="js/jquery-2.2.4.js"></script>
<script type="text/javascript" src="js/seatingarrangement.js"></script>
</head>
<body>
<form >
<input type="hidden" name="countofFemaleSeats" value="${countofFemaleSeats}" /> 
<%int iter=0;%>
<c:forEach items="${femaleSeats}" var="bean" >
          								
               <input type="hidden" name="femaleseatss<%=iter%>" value="<c:out value="${bean}" />">  
              
              <%iter++;%>
       
        </c:forEach>
  </form>      
        
        
	<table border="1" id="viewseat" >
		

		<tr>
			<td><label> s1</label><br><input type="checkbox" value="None" id="s1" class="class" 
				name="s1" /></td>
			<td><label> s5</label><br><input type="checkbox" value="None" id="s5" class="class"
				name="s5" /></td>
			<td><label> s9</label><br><input type="checkbox" value="None" id="s9" class="class"
				name="check" /></td>
			<td><label> s13</label><br><input type="checkbox" value="None" id="s13" class="class"
				name="check" /></td>
			<td><label> s17</label><br><input type="checkbox" value="None" id="s17" class="class"
				name="check" /></td>
			<td><label> s21</label><br><input type="checkbox" value="None" id="s21" class="class"
				name="check" /></td>
			<td><label> s25</label><br><input type="checkbox" value="None" id="s25" class="class"
				name="check" /></td>
			<td><label> s29</label><br><input type="checkbox" value="None" id="s29" class="class"
				name="check" /></td>
			<td><label> s33</label><br><input type="checkbox" value="None" id="s33" class="class"
				name="check" /></td>
			<td><label id="s40"> s37</label><br><input type="checkbox" value="None" id="s37" class="class"
				name="check" /></td>
		</tr>

		


		<tr>
			<td><label> s2</label><br><input type="checkbox" value="None" id="s2" class="class"
				name="check" /></td>
			<td><label> s6</label><br><input type="checkbox" value="None" id="s6" class="fg"
				name="s6" /></td>
			<td><label> s10</label><br><input type="checkbox" value="None" id="s10" class="class"
				name="check" /></td>
			<td><label> s14</label><br><input type="checkbox" value="None" id="s14" class="class"
				name="check" /></td>
			<td><label> s18</label><br><input type="checkbox" value="None" id="s18" class="class"
				name="check" /></td>
			<td><label> s22</label><br><input type="checkbox" value="None" id="s22" class="class"
				name="check" /></td>
			<td><label> s26</label><br><input type="checkbox" value="None" id="s26" class="class"
				name="check" /></td>
			<td><label> s30</label><br><input type="checkbox" value="None" id="s30" class="class"
				name="check" /></td>
			<td><label> s34</label><br><input type="checkbox" value="None" id="s34" class="class"
				name="check" /></td>
			<td><label> s38</label><br><input type="checkbox" value="None" id="s38" class="class"
				name="check" /></td>
		</tr>
		<tr bordercolor="white">
			<td colspan="10" height="20pt"></td>
		</tr>
		


		<tr>
			<td><label> s3</label><br><input type="checkbox" value="None" id="s3"
				name="check" /></td>
			<td><label> s7</label><br><input type="checkbox" value="None" id="s7"
				name="check" /></td>
			<td><label> s11</label><br><input type="checkbox" value="None" id="s11"
				name="check" /></td>
			<td><label> s15</label><br><input type="checkbox" value="None" id="s15"
				name="check" /></td>
			<td><label> s19</label><br><input type="checkbox" value="None" id="s19"
				name="check" /></td>
			<td><label> s23</label><br><input type="checkbox" value="None" id="s23"
				name="check" /></td>
			<td><label> s27</label><br><input type="checkbox" value="None" id="s27"
				name="check" /></td>
			<td><label> s31</label><br><input type="checkbox" value="None" id="s31"
				name="check" /></td>
			<td><label> s35</label><br><input type="checkbox" value="None" id="s35"
				name="check" /></td>
			<td><label> s39</label><br><input type="checkbox" value="None" id="s39"
				name="check" /></td>
		</tr>

		
		


		<tr>
			<td><label> s4</label><br><input type="checkbox" value="None" id="s4"
				name="check" /></td>
			<td><label> s8</label><br><input type="checkbox" value="None" id="s8"
				name="check" /></td>
			<td><label> s12</label><br><input type="checkbox" value="None" id="s12"
				name="check" /></td>
			<td><label> s16</label><br><input type="checkbox" value="None" id="s16"
				name="check" /></td>
			<td><label> s20</label><br><input type="checkbox" value="None" id="s20"
				name="check" /></td>
			<td><label> s24</label><br><input type="checkbox" value="None" id="s24"
				name="check" /></td>
			<td><label> s28</label><br><input type="checkbox" value="None" id="s28"
				name="check" /></td>
			<td><label> s32</label><br><input type="checkbox" value="None" id="s32"
				name="check" /></td>
			<td><label> s36</label><br><input type="checkbox" value="None" id="s36"
				name="check" /></td>
			<td><label> s40</label><br><input type="checkbox" value="None" id="s40"
				name="check" /></td>
		</tr>

	</table>
	<%-- <p>
	<%=  request.getAttribute("femaleSeats")  %>
</p> --%>


<html:form styleId="myform" action="seatBooking">

<p>Selected Seats are</p>
	<table id="blacklistgrid">
		
			<tr id="Row1" >
				<td class="space"></td>
			</tr>
			
			<tr id="Row2">
			</tr>
			
		</table>
		<p>Total Seat Selected</p>
		<input type="text" name="noofseatselectedbyuser" id="noofseatselectedbyuser">
		<html:submit value="proceed"></html:submit>
	</html:form>
</body>
</html>