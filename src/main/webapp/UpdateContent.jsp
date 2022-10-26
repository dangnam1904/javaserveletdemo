<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Edit profile</title>
</head>
<% if(session.getAttribute("sessionName")==null){
	
	request.getRequestDispatcher("Login.jsp").forward(request, response);
	}
	
%>
<body>
<%@ include file="formStyle.jsp" %>
<div class="main">

<h1> Update Content</h1>
<hr style="font-weight:5px">

	<div class="edit">
	<form action="update" method="post" class="editProfile">
	
   <legend style="background-color: #eaecef; font-size: 20px">Content  Form Elements</legend>
   <fieldset style="border: 3px solid  #eaecef; margin: 0px">
   <p></p>
   <input name="id" class="input_info" value="${c.id}" type="text" style="display: none"><br>
	<label>Title</label><br>
	<input name="title" class="input_info" value="${c.title}" type="text" placeholder="Enter the title"><br>
	<label>Brief</label><br>
	<textarea  name="brief" style="resize: none" values="${c.brief}"  rows="5" cols="110">${c.brief}</textarea><br>
	<label>Content </label><br>
	<textarea name="content"  value="${c.content}" style="resize: none" rows="10" cols="110">${c.content}</textarea><br>
	<input type="submit" value="Submit" class="complete_from">
	</fieldset>
	 <label class="block clearfix" > <%=request.getAttribute("msg") != null ? request.getAttribute("msg") : " "%></label>
	</form>
	</div>
</div>

</body>
</html>