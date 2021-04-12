package com.endsoul.book.web_tech.ch8.ex03.location;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/first_location")
public class FirstServlet extends HttpServlet {

  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp)
      throws ServletException, IOException {
    resp.setContentType("text/html; charset=utf-8");
    PrintWriter writer = resp.getWriter();
    writer.print("<script type='text/javascript'>location.href = 'second_location';</script>");
    writer.close();
  }
}
