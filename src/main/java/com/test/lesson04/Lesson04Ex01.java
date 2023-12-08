package com.test.lesson04;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.test.common.MysqlService;

@WebServlet("/lesson04/ex01")
public class Lesson04Ex01 extends HttpServlet{
	
	@Override
	public void doGet(HttpServletRequest request,
			HttpServletResponse response) throws IOException {
		
		// 응답값 plain(순수 글자)
		response.setContentType("text/plain");
		
		// DB연결
		MysqlService ms = MysqlService.getInstance(); // mysqlservice 객체를 가져옴
		ms.connect(); // 실질적인 연결(꼭 넣어야함!!)
		
		// DB 인서트
		String insertQuery = "insert into `used_goods`\r\n"
				+ "(`sellerId`,`title`,`description`,`price`)\r\n"
				+ "values\r\n"
				+ "(1,'고양이 간식 팝니다!', '까다로워서 잘 안먹어요ㅠ', 2000);";
		
		try {
			// 쿼리 작성을 내가 잘못한거니 try-catch
			ms.update(insertQuery);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		// DB 셀렉트 & 출력
		PrintWriter out = response.getWriter();		
		String query = "select * from `used_goods`";
		try {
			ResultSet res = ms.select(query); // query 진짜 수행 부분
			while(res.next()) { // 결과 행이 있는 동안 수행 , res = query 구문
				out.println(res.getInt("id")); // 컬럼명이 "id"인 값을 꺼내온다.
				out.println(res.getString("title"));
				out.println(res.getInt("price"));
				out.println(res.getString("description"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		// DB 연결 해제
		ms.disconnect();
	}
}
