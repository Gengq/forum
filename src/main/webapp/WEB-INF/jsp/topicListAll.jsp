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
<title>版块</title>
</head>
<body>
<%@ include file="includeTop.jsp" %>
<h1>${board.board_name }版块</h1>
<br/>
<c:forEach var="topic" items="${topics}">
	<tr>
	<td><a href="${context }/postListAll-${topic.topic_id}.html">${topic.topic_title}</a></td>
	<td>${topic.create_time }</td>
	<td>${topic.topic_views }</td>
	</tr>
	<hr/>
</c:forEach>

<a href="${context }/addTopicPage-${board.board_id }.html">新建话题</a>
</body>
</html>