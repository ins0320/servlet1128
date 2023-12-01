<%@page import="java.util.Scanner"%>
<%@page import="java.util.Arrays"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>test01</title>
</head>
<body>
<%!
	//선언문
	//input:끝수(n) output:결과값
	// 1. 1부터 n까지의 합계를 구하는 함수
	public int Nsum(int n){
		int sum = 0;
		for(int i = 1; i <= n; i++ ){
			sum += i;
		}
		return sum;
	}
%>
<% 
	// 스크립틀릿
	// 2. 점수들의 평균 구하기
	int sum = 0;
	int[] scores = {80, 90, 100, 95, 80};
	for(int i = 0; i < scores.length; i++){
		sum += scores[i];
	} 
	double avg = sum / (double) scores.length;

	//3. 채점 결과
	List<String> scoreList = Arrays.asList(new String[]{"X", "O", "O", "O", "X", "O", "O", "O", "X", "O"});
	
	int score = 0;
	for(int i = 0; i < scoreList.size();i++){
		if(scoreList.get(i).equals("O")){
			score += 100 / scoreList.size();
		}
	}
	

	//4. 나이 구하기
	String birthDay = "20010820";
	String yearString = birthDay.substring(0,4);
	int year = Integer.parseInt(yearString);
	int age = 2023 - year + 1; 
%>
	<!-- 함수 호출 위치 -->
	1부터 50까지의 합은 <%=Nsum(50) %> 입니다.	
	<br>
	평균 점수는 <%=avg %> 입니다.
	<br>
	채점 결과는 <%=score %> 입니다.
	<br>
	<%=birthDay %> 의 나이는 <%=age %>세 입니다.
</body>
</html>