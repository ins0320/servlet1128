<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>날짜,시간 링크</title>
</head>
<body>
<%
	String link = request.getParameter("link");
	Date now = new Date();
	SimpleDateFormat fmt = null;
	if(link.equals("time")){
		fmt = new SimpleDateFormat("현재 시간 H시 m분 s초 입니다.");
	}else if(link.equals("date")){
		fmt = new SimpleDateFormat("오늘 날짜는 yyyy년 M월 d일 입니다.");
	}
	String text = fmt.format(now);
	
%>
	<div> <%=text %></div>
</body>
</html>