package com.endsoul.book.web_tech.ch8.ex02.refresh;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/second_refresh")
public class SecondServlet extends HttpServlet {

  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp)
      throws ServletException, IOException {
    resp.setContentType("text/html; charset=utf-8");
    PrintWriter writer = resp.getWriter();
    writer.print("<html><body>refresh 를 이용한 redirect 실습입니다.</body></html>");
    writer.close();
  }
}
