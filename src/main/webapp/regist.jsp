<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>    
<%
	String context = request.getContextPath();
	request.setAttribute("context", context);
 %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>注册</title>
</head>
<body>
<c:if test="${!empty error }">
	<font color="red"><c:out value="${error }"/></font>
</c:if>
<form action="${context}/regist.html" method="post">
<table>
	<tr>
		<td>
			用户名
		</td>
		<td>
			<input name="userName" type="text"/>		
		</td>
	</tr>
	<tr>
		<td>
			密码
		</td>
		<td>
			<input name="password" type="password"/>		
		</td>
	</tr>
	<tr>
		<td>
			<input type="submit"/>		
		</td>

	</tr>
</table>
</form>
</body>
</html>