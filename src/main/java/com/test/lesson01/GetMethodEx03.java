package com.test.lesson01;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

// 어노테이션을 통해, "/lesson01/ex03" 경로로 요청이 들어왔을 때 시작되게 만든다.
@WebServlet("/lesson01/ex03")
public class GetMethodEx03 extends HttpServlet{
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
		// 한글 깨짐 방지
		response.setCharacterEncoding("utf-8"); 
		// response.setContentType("text/plain");
		response.setContentType("text/json");
		
		// Request Parameter 받아오기
		// request.getParameter("user_id"): user_id라는 이름으로 값을 얻어온다.
		// 여기서의 user_id는 url의 쿼리스트링을 통해 받아온다.
		// 즉 html에서 정한 이름으로 받아오게 된다.
		String userId = request.getParameter("user_id");
		String name= request.getParameter("name");
		int age = Integer.parseInt(request.getParameter("age"));
		
		
		
		PrintWriter out = response.getWriter();
//		out.println("결과");
//		out.println("user_id: " + userId);
//		out.println("name: " + name);
//		out.println("age: " + age);
		
		//json형태: {"key": value}
		// value는 값 형태에 따라 string이면 "string", int면 3
		// {"user_id":"marobiana", "name":"김유정", "age":30 }
		
		// \ 등의 모양을 표현하려면 "를 뒤에 붙여준다. 예) \"
		out.print("{\"user_id\":\"" + userId + "\", \"name\":\"" + name + "\", \"age\":" + age + "}");
	}
}
