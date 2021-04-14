package com.endsoul.book.web_tech.ch9.ex01.cookie;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLDecoder;
import java.util.Arrays;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/get")
public class GetCookieServlet extends HttpServlet {

  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp)
      throws ServletException, IOException {
    Cookie[] cookies = req.getCookies();
    // TODO: 함수형
    for (Cookie cookie : cookies) {
      if (cookie.getName().equals("cookieTest")) {
        resp.setContentType("text/html;charset=utf-8");
        PrintWriter writer = resp.getWriter();
        writer.print("<h2>Cookie 값 가져오기: " + URLDecoder.decode(cookie.getValue(), "utf-8") + "</h2>");
      }
    }
  }
}
