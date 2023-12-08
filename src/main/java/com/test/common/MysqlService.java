package com.test.common;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class MysqlService {
    private static MysqlService mysqlService = null;
    
    
    private static final String url = "jdbc:mysql://localhost:3306/yj"; // 도메인 뒤에 접속할 DB명까지 적는다.
    private String id = "root";
    private String pw = "root"; // 본인이 설정한 비밀번호를 작성한다.

    private Connection conn = null;
    private Statement statement;
    private ResultSet res;

    // Singleton 패턴: MysqlService라는 객체가 단 하나만 생성되도록 하는 디자인 패턴(DB 연결을 여러 객체에서 하지 않도록)
    public static MysqlService getInstance() {
        if (mysqlService == null) {
            mysqlService =  new MysqlService();
        }
        return mysqlService;
    }
    
    // DB 연결 생성
    public void connect() {
    	// 잘못됐다면, 요청에 의해 잘못된 것이 아니니까 DB(본인)가 책임지겠다 -> try-catch문
        try {
            // 1. 드라이버 메모리에 로딩
            DriverManager.registerDriver(new com.mysql.jdbc.Driver());

            // 2. DB connection (connection에 대한 정보: conn에 저장)
            conn = DriverManager.getConnection(url, this.id, this.pw);

            // 3. statement: DB와 쿼리를 실행하기 위한 준비 ( connection된 상태에서 실행)
            statement = conn.createStatement();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    //DB 연결 해제
    public void disconnect() {
    	// 잘못됐다면, 요청에 의해 잘못된 것이 아니니까 DB(본인)가 책임지겠다 -> try-catch문
        try {
            // 연결 끊기 ( statement 종료, connection 종료)
            statement.close();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    // CUD 문 (수행 시키면 끝 , 수행 결과 받아올 거 없다.)
    // 요청을 받아와서 쿼리문을 수행
    // 쿼리문을 만든 servlet,jsp의 잘못일 확률이 큼 -> 요청을 한 servlet,jsp에서 책임진다. -> throws
    public void update(String query) throws SQLException {
        statement.executeUpdate(query);
    }

    // R문 ( 외부에서 수행 결과를 담는다.)
    // 요청을 받아와서 쿼리문을 수행
    // 쿼리문을 만든 servlet,jsp의 잘못일 확률이 큼 -> 요청을 한 servlet,jsp에서 책임진다. -> throws
    // 수행결과: reseultset
    public ResultSet select(String query) throws SQLException {
        res = statement.executeQuery(query);
        return res;
    }
 
}