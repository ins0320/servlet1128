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

@WebServlet("/lesson04/test01")
public class Lesson04Test01 extends HttpServlet{
	@Override
	public void doGet(HttpServletRequest request,
			HttpServletResponse response) throws IOException {
		
		// 응답값 plain(순수 글자)
		response.setContentType("text/plain");
		
		// DB연결
		MysqlService ms = MysqlService.getInstance(); // mysqlservice 객체를 가져옴
		ms.connect(); // 실질적인 연결(꼭 넣어야함!!)
		
		// DB 인서트
		/*realtorId	address	area	type	price	rentPrice
			3	헤라펠리스 101동 5305호	350	매매	1500000	NULL
		 */
		String insertQuery = "insert into `real_estate`\r\n"
				+ "(`realtorId`,`address`,`area`,`type`,`price`)\r\n"
				+ "values\r\n"
				+ "(3,'헤라펠리스 101동 5305호','350','매매','1500000');";

		try {
			// 쿼리 작성을 내가 잘못한거니 try-catch
			ms.update(insertQuery);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		// DB 셀렉트 & 출력
		PrintWriter out = response.getWriter();	
		String query ="select * from `real_estate`order by `id` desc limit 10;";
		try {
			ResultSet res = ms.select(query); // query 진짜 수행 부분
			while(res.next()) { // 결과 행이 있는 동안 수행 , res = query 구문
				out.print("매물주소:" + res.getString("address"));
				out.print(", 면적:" + res.getInt("area"));
				out.print(", 타입:" + res.getString("type")+"\n");
				
			}
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		// DB 연결 해제
				ms.disconnect();
	}
}
