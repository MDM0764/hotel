<!DOCTYPE html PUBLIC "_//W#C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8"
<title>Register User</title>
</head>
<body>
<h2>Registered</h2>
<form action="login" method="post">
Email/phone no: <input type="text" name="userId">
Password: <input type="text" name="password">
<input type="submit" value="login"/>
</form
<div>
<c:if test="${not empty msg}">
   Error: ${msg}
</c:if>
<a href = "http://localhost:8080/hotel/register">
<button>login</button></a>
</div>
</body>
</html>