<%--
  Created by IntelliJ IDEA.
  User: klaud
  Date: 13.09.2022
  Time: 14:37
  To change this template use File | Settings | File Templates.
--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>Blog</h1>

<a href="/"><input type="button" value="Wyloguj"></a>
<a href="/"><input type="button" value="Dodaj wpiiiiiis"></a>
<c:forEach items="${blogPost}" var="post">
  <p>
    <a href="/show_post?id=${post.id}">${post.title}</a>
  </p>
</c:forEach>
</body>
</html>
