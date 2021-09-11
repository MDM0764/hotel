<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
</head>
<body>
<H3>LOGGED IN</H3>
<label>booking date</label>
<form action="bookTable" method="post">
    <label>data and time</label><input type="datetime-local">
    <label>NO of seats</label><input type="number" max="50"/>
<input type="hidden" name ="userCode" value = "${userCode}"/>
</body>
</html>us