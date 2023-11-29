package com.test.lesson01;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/lesson01/test06")
public class GetMethodTest03  extends HttpServlet{

	@Override 
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
		
		response.setContentType("text/html");
		response.setCharacterEncoding("utf-8");
		
		String address = request.getParameter("address");
		String card = request.getParameter("card");
		String price = request.getParameter("price");
		
		PrintWriter out = response.getWriter();
	
		out.print("<html><head><title>배탈의민족</title></head><body>");
				
		if(!address.contains("서울시")) {
			out.print("배달 불가 지역입니다");
		}else if(card.equals("신한카드")) {
			out.print("결제 불가 카드입니다.");
		}else {
			out.print(address + "<b>배달준비중</b> <br> 결제금액: " + price + "원"  );
		}
		
		out.print("</body></html>");
	}
}
