<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="java.util.List"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Date time calculator</title>
</head>
<body>
<center>
<h3>Date Time Calculator</h3>
<br>


<% List eList = (List)session.getAttribute("hist");
   request.setAttribute("eList ", eList );
%>
<ul>
<c:forEach items="${hist}" var="history">

<li> Serial No. : ${history.id}
<li> Date Selected : ${history.selectedDate}
<li>operation Selected: ${history.operationSelected}
<li> operands :  ${history.operands}
<li>Result :  ${history.result}


    
</c:forEach>
</ul>
</center>



</body>
</html>