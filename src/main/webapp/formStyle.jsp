<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Edit profile</title>
<link href="/JWEB.P.A101/Css/styles.css" rel="stylesheet">
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.4/css/all.min.css" />
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.9.1/font/bootstrap-icons.css">
</head>
<body>
<div class="header">
	<div class="logo">CMS</div>
	<div class="dropdown">
		<button class="nut_dropdown">
			<i id="i.fa_user" class="fas fa-user"
				style="float: right; color: black;padding-left: 110px; font-size: 20px"></i><i
				class="fas fa-caret-down"
				style="float: right; padding-left: 0px; margin-right: -140px; color: black; font-size: 20px"></i>
		</button>
		<div class="noidung_dropdown">
			<a href="editProfile"><i class="fas fa-user" style="padding-right: 15px"></i>User Profile</a> <a href="logout"><i
				class="fas fa-sign-out-alt" style="padding-right: 15px"></i>Logout</a>
		</div>
	</div>

	<div class="sidenav">

		<form id="nav-search" action="seachContent" method="get">
			<div class="inputSeach">
				<input id="search" name="seachcontent" placeholder="Search ...">
    
				<button class="btn_search" style="width: 25px; height: 25px;position: absolute; margin-left: -28px;
    margin-top: 2px;">
				<i class="fas fa-search" style="position: absolute;margin: 5px; margin-right: 7px; margin-left: 3px;left:0px; margin-top: -5px;"></i></button>
			</div>
		</form>
		<a href="viewContent"><i class="fas fa-bars" style="margin-right: 6px"></i>Product</a> <a href="AddContent.jsp"><i class="fas fa-clipboard-list"
			style="margin-right: 6px"></i>Form Content</a>
	</div>
</div>
</body>
</html>