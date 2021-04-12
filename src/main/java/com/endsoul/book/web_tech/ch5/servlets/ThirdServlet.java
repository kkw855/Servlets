package com.endsoul.book.web_tech.ch5.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/third")
public class ThirdServlet extends HttpServlet {

  public ThirdServlet() {
    super();
    System.out.println("Third 생성자 메서드 호출");
  }

  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp)
      throws ServletException, IOException {
    System.out.println("Third doGet 메서드 호출");
  }

  @Override
  public void destroy() {
    System.out.println("Third destroy 메서드 호출");
  }

  @Override
  public void init() throws ServletException {
    System.out.println("Third init 메서드 호출");
  }
}
