package com.endsoul.book.web_tech.ch7.ex01.statement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import java.sql.Date;

import java.util.List;
import java.util.ArrayList;

public class MemberDAO {

  private static final String driver = "org.postgresql.Driver";
  private static final String url = "jdbc:postgresql://localhost:5432/java_tech";
  private static final String user = "postgres";
  private static final String pwd = "dnjsclr1";

  private Statement stmt;
  private Connection con;

  @SuppressWarnings("DuplicatedCode")
  public List<MemberVO> listMembers() {
    List<MemberVO> list = new ArrayList<>();

    try {
      con();
      String query = "SELECT * FROM t_member";
      System.out.println(query);
      ResultSet rs = stmt.executeQuery(query);
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
      stmt.close();
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
      stmt = con.createStatement();
      System.out.println("Statement 생성 성공");
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}
