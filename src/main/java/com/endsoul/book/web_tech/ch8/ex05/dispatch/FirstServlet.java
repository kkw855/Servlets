package com.endsoul.book.web_tech.ch8.ex05.dispatch;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/first_dispatch")
public class FirstServlet extends HttpServlet {

  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp)
      throws ServletException, IOException {
    RequestDispatcher dispatcher = req.getRequestDispatcher("second_dispatch?name=lee");
    dispatcher.forward(req, resp);
  }
}
