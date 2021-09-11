<!DOCTYPE html PUBLIC "_//W#C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8"
<title>Register User</title>
</head>
<body>
<form action="registerUser" method="post">
Email: <input type="email" name="email">
PhoneNo: <input type="tel" name="phoneno">
Name: <input type="text" name="name">
Password: <input type="text" name="password">
Confirm Password: <input type="text" name="password">
<input type="submit" value="register"/>
<div>
<c:if test="${not empty msg}">
   Error: ${msg}
</c:if>
</div>
</form>
<a href = "http://localhost:8080/hotel/login">
<button>login</button></a>
</body>
</html>