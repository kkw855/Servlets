package com.endsoul.book.web_tech.ch8.ex09.servlet_config;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = {"/sInit", "/sInit2"}, initParams = {
    @WebInitParam(name = "email", value = "admin@web.com"),
    @WebInitParam(name = "tel", value = "010-1111-2222")})
public class InitParamServlet extends HttpServlet {

  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp)
      throws ServletException, IOException {
    String email = getInitParameter("email");
    String tel = getInitParameter("tel");

    resp.setContentType("text/html;charset=utf-8");
    PrintWriter writer = resp.getWriter();
    writer.print("<html><body>");
    writer.print("<table>");
    writer.print("<tr><td>email:</td><td>" + email + "</td></tr>");
    writer.print("<tr><td>휴대전화:</td><td>" + tel + "</td></tr>");
    writer.print("</table>");
    writer.print("</body></html>");
    writer.close();
  }
}
