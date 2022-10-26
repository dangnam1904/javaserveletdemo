<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Home</title>
</head>
<% if(session.getAttribute("sessionName")==null){
	
	request.getRequestDispatcher("Login.jsp").forward(request, response);
	}
	
%>

<body>
<%@ include file="formStyle.jsp" %>

</body>
</html>