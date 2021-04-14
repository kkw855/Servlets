package com.endsoul.book.web_tech.ch9.ex01.cookie;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLEncoder;
import java.util.Date;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/set")
public class SetCookieValue extends HttpServlet {

  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp)
      throws ServletException, IOException {
    Cookie cookie = new Cookie("cookieTest", URLEncoder.encode("JSP 프로그래밍 입니다.", "utf-8"));
    cookie.setMaxAge(24 * 60 * 60);
    resp.addCookie(cookie);
    resp.setContentType("text/html;charset=utf-8");
    PrintWriter out = resp.getWriter();
    out.println("현재시간 : " + new Date());
    out.println("<br/> 문자열을 Cookie 에 저장합니다.");
  }
}
