<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/4/11 0011
  Time: 上午 9:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="${pageContext.request.contextPath}/test" method="get">
    <button type="submit" >提交</button>
</form>
delete请求请求必须为post类型才能够转成put,delete
<form action="${pageContext.request.contextPath}/delete" method="post">
    <input type="hidden" name="_method" value="DELETE">
    <button type="submit" >提交</button>
</form>

</body>
</html>
