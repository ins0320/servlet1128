package com.test.lesson01;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/lesson01/test07")
public class GetMethodTest04 extends HttpServlet{
	@Override 
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
		
		response.setContentType("text/html");
		response.setCharacterEncoding("utf-8");
		
		String search = request.getParameter("search");
		
		PrintWriter out = response.getWriter();
		
		//검색어 리스트
		List<String> list = new ArrayList<>(Arrays.asList(
		        "강남역 최고 맛집 소개 합니다.", 
		        "오늘 기분 좋은 일이 있었네요.", 
		        "역시 맛집 데이트가 제일 좋네요.", 
		        "집에 가는 길에 동네 맛집 가서 안주 사갑니다.",
		        "자축 저 오늘 생일 이에요."));
		out.print("<html><head><title>검색하기</title></head><body>");
		int i = 0;
		for (String keyword : list) {
			if(keyword.contains(search)) {
				keyword = keyword.replace(search, "<b>"+ search + "</b>");
				out.print(keyword + "<br>");
			}
		}
		//iterator 사용
//		Iterator<String> iter = list.iterator();
//		while(iter.hasNext()) {
//			String line = iter.next();
//			if(line.contains(search)) {
//				out.print(line + "<br>");
//			}
//		}
		out.print("</body></html>");
	}
}
