<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>添加新版块</title>
</head>
<body>
<h1>添加新版块</h1>
<form action="<c:url value="/addBoard.html"/>" method="post">
版块名：<input type="text" name="board_name">
版块描述：<input type="text" name="board_desc">
<input type="submit">
</form>
</body> 
</html>