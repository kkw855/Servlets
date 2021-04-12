package com.endsoul.book.web_tech.ch7.ex03.data_source;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class MemberDAO {

  private DataSource dataFactory;

  public MemberDAO() {
    try {
      Context ctx = new InitialContext();
      // TODO: java:/comp/env 무슨 의미인지?
      Context envContext = (Context) ctx.lookup("java:/comp/env");
      dataFactory = (DataSource) envContext.lookup("jdbc/postgresql");
    } catch (NamingException e) {
      e.printStackTrace();
    }
  }

  public List<MemberVO> listMembers() {
    List<MemberVO> list = new ArrayList<>();

    try {
      Connection con = dataFactory.getConnection();
      String query = "SELECT * FROM t_member";
      System.out.println("PreparedStatement: " + query);
      PreparedStatement pstmt = con.prepareStatement(query);
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
}
