package com.endsoul.book.web_tech.ch7.ex02.prepared_statement;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import java.util.ArrayList;
import java.util.List;

public class MemberDAO {

  private static final String driver = "org.postgresql.Driver";
  private static final String url = "jdbc:postgresql://localhost:5432/java_tech";
  private static final String user = "postgres";
  private static final String pwd = "dnjsclr1";

  private PreparedStatement pstmt;
  private Connection con;

  @SuppressWarnings("DuplicatedCode")
  public List<MemberVO> listMembers() {
    List<MemberVO> list = new ArrayList<>();

    try {
      con();
      String query = "SELECT * FROM java_tech.public.t_member";
      System.out.println("PreparedStatement: " + query);
      pstmt = con.prepareStatement(query);
      ResultSet rs = pstmt.executeQuery();
      while (rs.next()) {
        String id = rs.getString("id");
        String pwd = rs.getString("pwd");
        String name = rs.getString("name");
        String email = rs.getString("email");
        Date joinDate = rs.getDate("joinDate");

        MemberVO vo = new MemberVO(id, pwd, name, email, joinDate);
        list.add(vo);
      }

      rs.close();
      pstmt.close();
      con.close();
    } catch (Exception e) {
      e.printStackTrace();
    }

    return list;
  }

  private void con() {
    try {
      Class.forName(driver);
      System.out.println("PostgreSQL 드라이버 로딩 성공");
      con = DriverManager.getConnection(url, user, pwd);
      System.out.println("Connection 생성 성공");
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}
