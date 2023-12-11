package com.test.lesson04;



import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.test.common.MysqlService;

@WebServlet("/lesson04/test02_insert")
public class InsertTest02 extends HttpServlet {

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
		
		String name = request.getParameter("name");
		String url = request.getParameter("url");
		
		// DB 연결
		MysqlService ms = MysqlService.getInstance();
		ms.connect();
		
		
		// DB 쿼리
		String query = "Insert into `bookmark`"
				+ "(`name`,`url`)\r\n"
				+ "values\r\n"
				+ "('" + name + "','" + url + "')";
		
		try {
			ms.update(query);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		// DB 연결해제
		ms.disconnect();
		
		// redirect ( 목록 리스트 페이지로 이동)
		response.sendRedirect("/lesson04/test02/test02_01.jsp");
	}
}
