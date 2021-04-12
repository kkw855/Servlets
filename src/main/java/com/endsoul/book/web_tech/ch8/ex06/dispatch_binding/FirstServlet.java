package com.endsoul.book.web_tech.ch8.ex06.dispatch_binding;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/first_dispatch_data")
public class FirstServlet extends HttpServlet {

  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp)
      throws ServletException, IOException {
    RequestDispatcher dispatcher = req.getRequestDispatcher("second_dispatch_data");
    req.setAttribute("address", "서울시 성북구");
    dispatcher.forward(req, resp);
  }
}
