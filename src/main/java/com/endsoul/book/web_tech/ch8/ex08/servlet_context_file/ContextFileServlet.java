package com.endsoul.book.web_tech.ch8.ex08.servlet_context_file;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/cfile")
public class ContextFileServlet extends HttpServlet {

  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp)
      throws ServletException, IOException {
    ServletContext context = getServletContext();
    InputStream is = context.getResourceAsStream("/WEB-INF/bin/init.txt");
    BufferedReader buffer = new BufferedReader(new InputStreamReader(is));
    String menu;
    String menu_member = null;
    String menu_order = null;
    String menu_goods = null;
    while ((menu = buffer.readLine()) != null) {
      StringTokenizer tokens = new StringTokenizer(menu, ",");
      menu_member = tokens.nextToken();
      menu_order = tokens.nextToken();
      menu_goods = tokens.nextToken();
    }

    resp.setContentType("text/html;charset=utf-8");
    PrintWriter writer = resp.getWriter();
    writer.print("<html><body>");
    writer.print(menu_member + "<br/>");
    writer.print(menu_order + "<br/>");
    writer.print(menu_goods);
    writer.print("</body></html>");
    writer.close();
  }
}
