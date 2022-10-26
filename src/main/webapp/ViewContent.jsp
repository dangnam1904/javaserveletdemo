	<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@page import="org.apache.jasper.tagplugins.jstl.core.ForEach"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Edit profile</title>
<script type="text/javascript" src="/JWEB.P.A101/js/min.js"></script>
</head>
<% if(session.getAttribute("sessionName")==null){
	
	request.getRequestDispatcher("Login.jsp").forward(request, response);
	}
	
%>
<body>
	<%@ include file="formStyle.jsp"%>
	<div class="main">

	<%  %>
		<h1>View Content</h1>
		<hr style="font-weight: 5px">

		<div class="edit">
				<legend style="background-color: #eaecef; font-size: 20px">View
					Contents</legend>
					<p></p>
				<table class="table table-zebra table-hover">
					<tr>

						<th>#</th>
						<th>Title</th>
						<th>Brief</th>
						<th>Content</th>
						<th>Create Date</th>
						<th>Action<th>
					</tr>
					<c:forEach items="${listContents}"  var="x">
					<tr>
					
					<td>${x.id} </td>
					<td>${x.title}</td>
					<td>${x.brief}</td>
					<td>${x.content}</td>
					<td>${x.createDate}<td>
					<td><a href="update?id=${x.id}">Edit</a> <a href="#" onclick="deleteContent(${x.id})">Delete</a> <td>
					</tr>
					</c:forEach>
				</table>
		</div>
	</div>


</body>
</html>