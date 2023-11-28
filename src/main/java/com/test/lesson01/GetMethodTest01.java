package com.test.lesson01;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/lesson01/test01-01")
public class GetMethodTest01 extends HttpServlet{
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
		// 한글 깨짐 방지
		response.setCharacterEncoding("utf-8"); 
		response.setContentType("text/html");
		
		int dan = Integer.parseInt(request.getParameter("number"));
		
		PrintWriter out = response.getWriter();
		
		out.print("<html><head><title>구구단</title><head><body><ul>");
		
		int i;
		for(i = 1; i < 10; i++) {
			out.print("<li>"+ dan + " X " + i + "=" + dan * i + "</li>");
		}
		out.print("</ul></body></html>");
	}
		
}
