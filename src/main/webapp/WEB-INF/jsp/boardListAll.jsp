<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<% String context = request.getContextPath();
	request.setAttribute("context", context);
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>首页</title>
</head>
<body>
<%@ include file="includeTop.jsp" %>
<h1>论坛</h1>
<table border="1">
<c:forEach var="board" items="${boards }">
	<tr>
		<td>${board.getBoard_name()}</td>
		<td>
			<a href="${context }/topicListAll-${board.board_id}.html">
				${board.getBoard_desc()}
			</a>
		</td>
	</tr>
</c:forEach>
</table>
<a href="${context }/newBoard.html">新建版块</a>
</body>
</html>