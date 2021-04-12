package com.endsoul.book.web_tech.ch6.servlets;

import java.io.IOException;
import java.util.Arrays;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/input")
public class InputServlet extends HttpServlet {

  @Override
  protected void doPost(HttpServletRequest req, HttpServletResponse resp)
      throws ServletException, IOException {
    req.setCharacterEncoding("UTF-8");
    String[] subjects = req.getParameterValues("subject");
    Arrays.stream(subjects).forEach(s -> System.out.println("선택한 과목: " + s));
  }

  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp)
      throws ServletException, IOException {
    String[] subjects = req.getParameterValues("subject");
    Arrays.stream(subjects).forEach(s -> System.out.println("선택한 과목: " + s));
  }
}
