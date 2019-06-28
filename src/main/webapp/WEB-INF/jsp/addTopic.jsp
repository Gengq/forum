<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%@ include file="includeTop.jsp" %>
<form action="<c:url value="/addTopic.html" />" method="post">
<table border="1px" >
	<tr>
		<td >标题</td>
		<td><input name="topic_title"></td>
	</tr>
	<tr>
		<td >内容</td>
		<td ><textarea style="width:100%;height:400px"  name="topic_title"></textarea></td>
	</tr>
	<tr>
		<td colspan="2" align="right">
		   <input type="submit" value="保存">
		   <input type="reset" value="重置">
		   <input type="hidden" name="boardId" value="${boardId}"> 
		</td>
	</tr>
</table>
</form>
</body>
</html>