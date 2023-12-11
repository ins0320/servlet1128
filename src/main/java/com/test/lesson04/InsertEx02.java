package com.test.lesson04;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.test.common.MysqlService;

@WebServlet("/lesson04/ex02_insert")
public class InsertEx02 extends HttpServlet{

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
		// 응답을 직접 내리지 않기 때문에 response header에 세팅하는 content type 과정 생략
		// response.setContentType("text/plain");
		
		// 사용자 정보 request params 꺼내기
		String name = request.getParameter("name");
		String yyyymmdd = request.getParameter("yyyymmdd");
		String email = request.getParameter("email");
		String introduce = request.getParameter("introduce");
		
		// DB 연결
		MysqlService ms = MysqlService.getInstance();
		ms.connect(); // DB 실제 연결!!
		
		// DB Insert 쿼리 수행
		String insertQyery= "insert into `new_user`"
			+	"(`name`,`yyyymmdd`,`email`,`introduce`)"
			+	"values"
			+	"('" + name + "','" + yyyymmdd + "','" + email + "','" + introduce + "')";
		
		try {
			ms.update(insertQyery);
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		
		// DB 연결 해제
		ms.disconnect();
		
		
		// 사용자 목록 화면으로 이동 -> Redirect (STATUS CODE: 302, 다른 페이지로 이동시킨다.)
		response.sendRedirect("/lesson04/ex02/ex02_01.jsp");
		
	}
}
