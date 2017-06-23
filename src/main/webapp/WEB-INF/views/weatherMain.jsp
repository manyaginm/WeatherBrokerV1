<%--
  Created by IntelliJ IDEA.
  User: MManiagin
  Date: 06.06.2017
  Time: 18:49
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <link href="<c:url value="/resources/css/home.css"/>" rel="stylesheet"/>
    <title>Title</title>
</head>
<body>
<h1>MAIN</h1>
<form action="weatherResult" method="POST" name="city">
    <input type="text" value="TEXT" name="city">
    <input type="submit"/>

</form>
</body>
</html>
