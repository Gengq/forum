<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>登陆</title>
</head>
<h1>登陆页面</h1>
<body>
<c:if test="${!empty error}">
	<font color="red"><c:out value="${error }"/></font>
</c:if>
${sessionScope.error}
<form action="<c:url value="/loginCheck.html"/>" method="post">
	用户名：
	<input type="text" name="userName"><br>
	密码：
	<input type="text" name="password"><br>
	<input type="submit" value="登陆">
</form>
</body>
</html>