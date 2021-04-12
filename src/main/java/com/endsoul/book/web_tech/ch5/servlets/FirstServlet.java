package com.endsoul.book.web_tech.ch5.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class FirstServlet extends HttpServlet {

  public FirstServlet() {
    super();
    System.out.println("First 생성자 메서드 호출");
  }

  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp)
      throws ServletException, IOException {
    System.out.println("First doGet 메서드 호출");
  }

  @Override
  public void destroy() {
    System.out.println("First destroy 메서드 호출");
  }

  @Override
  public void init() throws ServletException {
    System.out.println("First init 메서드 호출");
  }
}
