<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link href="/JWEB.P.A101/Css/styles.css" rel="stylesheet">
<script type="text/javascript" src="/JWEB.P.A101/js/min.js"></script>
</head>

<body>

	<form action="register" method="post">
		<p>Resigter
		<p>
		<div class="container">
			<input class="uname" type="text" placeholder="Enter Username"
				name="uname" required> <br> <input name="email"
				class="email" placeholder="Enter Email"> <input class="pws"
				type="password" id="password" placeholder="Enter Password"
				name="pws" required> <br> <input class="re-pws"
				type="password" placeholder="Re -Enter Password"
				id="confirm_password" name="pws" required> <br> <input
				class="submit" value="Register" type="submit" onclick="checkPass()">
			<br> <a href="Login.jsp"> Click here to login</a>
		</div>

	</form>

</body>
</html>
