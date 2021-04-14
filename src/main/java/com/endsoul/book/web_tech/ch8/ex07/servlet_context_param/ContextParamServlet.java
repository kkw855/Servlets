package com.endsoul.book.web_tech.ch8.ex07.servlet_context_param;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/initMenu")
public class ContextParamServlet extends HttpServlet {

  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp)
      throws ServletException, IOException {
    ServletContext context = getServletContext();
    // TODO: 리스트 등으로 묶어서 스트림으로 처리
    String menu_member = context.getInitParameter("menu_member");
    String menu_order = context.getInitParameter("menu_order");
    String menu_goods = context.getInitParameter("menu_goods");

    resp.setContentType("text/html;charset=utf-8");
    PrintWriter writer = resp.getWriter();
    writer.print("<html><body>");
    writer.print("<table border='1' cellspacing='0'>");
    writer.print("<tr>메뉴 이름</tr>");
    writer.print("<tr><td>" + menu_member + "</td></tr>");
    writer.print("<tr><td>" + menu_order + "</td></tr>");
    writer.print("<tr><td>" + menu_goods + "</td></tr>");
    writer.print("</table>");
    writer.print("</body></html>");
    writer.close();
  }
}
