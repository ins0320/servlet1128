package com.test.lesson01;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/lesson01/test09")
public class PostMethodTest02 extends HttpServlet{

	//전달 받은 id와 password가 아래에 주어진 사용자 정보와 일치 하는지 확인하세요.
	// doPost 메소드 바깥쪽에 위치
	private final Map<String, String> userMap =  new HashMap<String, String>() {
	    {
	        put("id", "marobiana");
	        put("password", "qwerty1234");
	        put("name", "신보람");
	    }
	};
	
	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
		response.setContentType("text/html");
		
		String id = request.getParameter("userId");
		String password = request.getParameter("password");
		
		
		PrintWriter out = response.getWriter();
		
		if(!id.equals(userMap.get("id"))) {
			out.print("id가 일치하지 않습니다.");
		}else if(!password.equals(userMap.get("password"))) {
			out.print("password가 일치하지 않습니다.");
		}else {
			out.print(userMap.get("name") + "님 환영합니다!");
		}
	}
}
