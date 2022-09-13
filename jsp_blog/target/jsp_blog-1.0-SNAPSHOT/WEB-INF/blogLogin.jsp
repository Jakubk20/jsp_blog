<%--
  Created by IntelliJ IDEA.
  User: klaud
  Date: 13.09.2022
  Time: 10:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>Logowanie</h1>
<form method='post'>
    <input type='text' name='login' placeholder='podaj login'>
    <input type='password' name='password' placeholder='podaj hasło'>
    <input type='submit' value='Zaloguj'>
</form>
${sessionScope.message}
</body>
</html>
