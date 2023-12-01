<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JSP</title>
</head>
<body>
	<!-- HTML 주석 -->
	<%-- JSP 주석 --%>
<%
	// 자바 문법 시작
	// scriptlet (spring에서 사용 안 함)
	
	// 1 ~ 10까지 더하기
	int sum = 0;
	for(int i = 1; i < 11; i++){
		sum += i;
	}
%>	
	<b>합계: </b>
	<input type="text" value="<%=sum %>">
	<br>
<%!
	// 선언문 - 클래스 같은 느낌
	
	// 필드
	private int num = 100;
	
	// 메소드
	public String getHelloWorld(){
		return "Hello World";
	}
%>	

<%-- 메소드 호출 --%>
<%=getHelloWorld() %> <br>
<%-- 변수 계산 --%>
<%=num + 20 %>
</body>
</html>