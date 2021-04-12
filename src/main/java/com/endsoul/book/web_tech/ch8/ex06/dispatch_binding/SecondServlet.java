package com.endsoul.book.web_tech.ch8.ex06.dispatch_binding;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/second_dispatch_data")
public class SecondServlet extends HttpServlet {

  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp)
      throws ServletException, IOException {
    String address = (String) req.getAttribute("address");
    resp.setContentType("text/html; charset=utf-8");
    PrintWriter writer = resp.getWriter();
    writer.print("<html><body>");
    writer.print("주소: " + address + "<br/>");
    writer.print("dispatch 를 이용한 바인딩 실습입니다.");
    writer.print("</body></html>");
    writer.close();
  }
}
