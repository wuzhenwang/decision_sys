<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml" xmlns:th="http://www.thymeleaf.org"
      xmlns:sec="http://www.thymeleaf.org/thymeleaf-extras-springsecurity3">
<head>
    <title>Hello World!</title>
</head>
<body>
<h1 th:inline="text">Hello </h1>
<form th:action="logout" method="get">
    <input type="submit" value="注销"/>
</form>
</body>
</html>