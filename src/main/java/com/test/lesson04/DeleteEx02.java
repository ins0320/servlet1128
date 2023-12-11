package com.test.lesson04;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.test.common.MysqlService;

@WebServlet("/lesson04/ex02_delete")
public class DeleteEx02 extends HttpServlet{

	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
		
		// DeleteEx02 -> ex02_01.jsp 로 redirect(302->200)
		
		//request parameter -> id
		int id = Integer.parseInt(request.getParameter("id"));
		
		
		// DB 연결
		MysqlService ms = MysqlService.getInstance();
		ms.connect();
		
		// DB 삭제 쿼리 수행
		String deleteQuery = "delete from `new_user` where `id` = " + id;
		try {
			ms.update(deleteQuery);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		// DB 연결 해제
		ms.disconnect();
		// 유저 목록화면으로 Redirect ( 302 redirect 에서 -> 200 ok 페이지로 보내기)
		response.sendRedirect("/lesson04/ex02/ex02_01.jsp");
	}
}
