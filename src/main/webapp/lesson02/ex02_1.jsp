<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>결과 페이지</title>
</head>
<body>
	<h1>결과</h1>
	<b>아이디</b>
	<%--  Servlet에서 사용하는 request.getParameter 방법과 동일함--%>
	<%= request.getParameter("user_id") %>
	<br>
	<b>이름</b>
	<%=request.getParameter("name") %>
	<br>
	<b>나이</b>
	<%=request.getParameter("age") %>
</body>
</html>