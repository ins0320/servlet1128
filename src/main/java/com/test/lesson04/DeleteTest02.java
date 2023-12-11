package com.test.lesson04;

import java.sql.SQLException;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.test.common.MysqlService;

@WebServlet("/lesson04/test02Delete")
public class DeleteTest02  extends HttpServlet{
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) {
		
		int id = Integer.parseInt(request.getParameter("id"));
		
		// DB 연결
		MysqlService ms = new MysqlService();
		ms.connect();
		
		// delete 쿼리
		String deleteQuery = "delete from `bookmark` where `id` = " + id;
		
		try {
			ms.update(deleteQuery);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		// DB 연결해제
		ms.disconnect();
		
		// 유저 목록화면으로 Redirect ( 302 redirect 에서 -> 200 ok 페이지로 보내기)
		response.sendRedirect("/lesson04/test02/test02_01.jsp");
	}

}
