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
	<%@ include file="formStyle.jsp"%>
	<div class="main">

		<h1>Edit Profile</h1>
		<hr style="font-weight: 5px">

		<div class="edit">
			<form action="editProfile" method="post" class="editProfile">

				<legend style="background-color: #eaecef; font-size: 20px">Profile
					Form Elements</legend>
				<fieldset style="border: 3px solid #eaecef; margin: 0px">
					<p></p>
					<label>First Name</label> <br> <input name="firstname"
						class="input_info" type="text" value="${m.firstName}"  placeholder="Enter the first name">
					<br> <label>Last Name</label><br> <input name="lastname"
						class="input_info" type="text" value="${m.lastName}" placeholder="Enter the last name"><br>
					<label>Email</label><br> <input class="input_info"
						name="email" type="email" value="${m.email}" placeholder="your_email@exmaple.com"><br>
					<label>Phone</label><br> <input class="input_info"
						name="phone" type="number" value="${m.phone}"  placeholder="Enter your phone number"><br>
					<label>Descrciption </label><br>
					<textarea name="descrciption" style="resize: none" rows="5"
						cols="110">${m.description}</textarea>
					<br> <input type="submit" value="Submit Button"
						class="complete_from"> <input type="button"
						value="Reset Button" class="complete_from">
				</fieldset>
				<label class="block clearfix" style="color: red"> <%=request.getAttribute("msg") != null ? request.getAttribute("msg") : " "%>
				</label>
			</form>
		</div>
	</div>

</body>
</html>