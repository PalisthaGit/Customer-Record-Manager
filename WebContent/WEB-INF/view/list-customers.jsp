<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>List Customers</title>

<link type="text/css"
      rel="stylesheet"
      href="${pageContext.request.contextPath}/resources/css/style.css"/>
</head>
<body>
	
	<div id="wrapper">
		<div id="header">
			<h2>Customer List</h2>
		</div>
	</div>

	<div id="container">
		<div id="content">
		
		<input type="button" value="Add Customer" onClick="window.location.href='showFormForAdd'; return false;" class="add-button"/>
		
		<table>
		<tr><th>First Name</th>
		<th>Last Name</th>
		<th>Email</th>
		<th>Action</th>
		<th></th>
		</tr>
		
		<c:forEach var="tempCustomer" items="${customers}">
		
		 <c:url var="updateLink" value="/customer/showFormForUpdate">
		 <c:param name="customerId" value="${tempCustomer.id}"/>
		     
		     </c:url>
		
		 <c:url var="delete" value="/customer/delete">
		 <c:param name="customerId" value="${tempCustomer.id}"/>
		     
		     </c:url>
		
		<tr><td>${tempCustomer.firstName}</td>
		     <td>${tempCustomer.lastName}</td>
		     <td>${tempCustomer.email}</td>
		     <td>  <a href="${updateLink}">Update</a></td>
		      <td>  <a href="${delete}" onclick="if(!(confirm('Are you sure?'))) return false">Delete</a></td>
		    
		     
	</tr>
	</c:forEach>
	</table>
	</div>
	</div>

</body>
</html>