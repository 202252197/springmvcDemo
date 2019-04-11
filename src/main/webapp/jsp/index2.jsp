<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/4/10 0010
  Time: 下午 8:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <c:forEach items="${list}" var="users" >
        <p>${users.id}==${users.name}==${users.age}</p>
    </c:forEach>
</body>
</html>
