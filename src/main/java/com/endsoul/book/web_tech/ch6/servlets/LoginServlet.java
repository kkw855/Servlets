package com.endsoul.book.web_tech.ch6.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {

  @Override
  protected void doPost(HttpServletRequest req, HttpServletResponse resp)
      throws ServletException, IOException {
    req.setCharacterEncoding("utf-8");
    resp.setContentType("text/html; charset=UTF-8");
    PrintWriter writer = resp.getWriter();

    String id = req.getParameter("id");
    String password = req.getParameter("password");

    writer.print("<html>");
    writer.print("<body>");
    if (id != null && id.length() != 0) {
      if (id.equals("admin")) {
        writer.print( "<div style='font-size: 2.0em;'>관리자로 로그인 하셨습니다!! </font>" );
        writer.print("<br>");
        writer.print("<input type=button value='회원정보 수정하기'  />");
        writer.print("<input type=button value='회원정보 삭제하기'  />");
      } else {
        writer.print( id +" 님!! 로그인 하셨습니다." );
      }
    } else {
      writer.print("ID와 비밀번호를 입력하세요!!!" ) ;
      writer.print("<br/>");
      writer.print("<a href='login.html'>로그인창으로 이동  </a>");
    }
    writer.print("</body>");
    writer.print("</html>");

    writer.close();
  }
}
