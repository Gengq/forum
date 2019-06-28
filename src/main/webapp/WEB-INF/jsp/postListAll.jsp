<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%
	String context = request.getContextPath();
	request.setAttribute("context", context);
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<c:if test="${!empty topic }">
	<p>${topic.topic_title }</p>
	<hr/>
</c:if>
<p>回复列表：</p>
<table border="1">
<c:forEach var="post" items="${posts}">
	<tr>
	<td>${post.post_title }</td>
	<td>${post.post_text }</td>
	</tr>
</c:forEach>
</table>
<a href="${context }/addPostPage-${topicId}.html">回复</a>
</body>
</html>