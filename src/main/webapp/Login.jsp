<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1">

<link href="/JWEB.P.A101/Css/styles.css" rel="stylesheet">
</head>
<body>

	<form action="login" method="post">
		<p>Plese sigin
		<p>
		<div class="container">
			<label class="block clearfix" style="color: red"> <%=request.getAttribute("msglogin") != null ? request.getAttribute("msglogin") : " "%>
			</label> <input class="uname" type="text" placeholder="Enter Username"
				name="uname" required> <br> <input class="pws"
				type="password" placeholder="Enter Password" name="pws" required>
			<br> <label> <input type="checkbox" class="checkbox"
				name="remember"> <span style="font-size: 15px">Remember
					me </span> <br> <br>
			</label> <input class="submit" type="submit" value="Login"></input> <br>
			<br> <label> <span class="psw"> <a
					href="Register.jsp">Click here to Resigter</a></span>
			</label>
		</div>

	</form>

</body>
</html>
