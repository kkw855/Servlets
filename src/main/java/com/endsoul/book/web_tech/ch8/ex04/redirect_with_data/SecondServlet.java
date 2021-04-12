package com.endsoul.book.web_tech.ch8.ex04.redirect_with_data;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/second_redirect_data")
public class SecondServlet extends HttpServlet {

  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp)
      throws ServletException, IOException {
    String name = req.getParameter("name");
    resp.setContentType("text/html; charset=utf-8");
    PrintWriter writer = resp.getWriter();
    writer.print("<html><body>이름: " + name + "</body></html>");
    writer.close();
  }
}
