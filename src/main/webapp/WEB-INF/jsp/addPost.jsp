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
<title>回复帖子</title>
</head>
<body>
<h1>回复:${topic.topic_title }</h1>
<form action="${context }/addPost.html" method="post">
回复标题：<input type="text" name="post_title"/>
回复内容<input type="text" name="post_text"/>
<input type="hidden" name="topicId" value="${topicId }"/>
<input type="submit"/>
</form>
</body>
</html>