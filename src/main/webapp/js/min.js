function checkPass() {
	let password = document.getElementById("password").value;
	let confirm_password = document.getElementById("confirm_password").value;
	console.log(password);
	if(password!=confirm_password){
		alert("Thông báo mật khẩu không trùng");
		
	}
}

function deleteContent(id){
	var option=	confirm("Bạn muốn xóa hàng có id:"+id);
	if(option===true){
		window.location.href="delete?id="+id;
	}
}