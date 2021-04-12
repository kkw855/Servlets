package com.endsoul.book.web_tech.ch7.ex03.data_source;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.stream.Stream;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/member3")
public class MemberServlet extends HttpServlet {

  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp)
      throws ServletException, IOException {
    resp.setContentType("text/html; charset=UTF-8");

    MemberDAO dao = new MemberDAO();
    Stream<MemberVO> members = dao.listMembers().stream();

    PrintWriter writer = resp.getWriter();
    writer.print("<html><body>");
    writer.print("<table border='1'><tr align='center' bgcolor='lightgreen'><td>아이디</td><td>비밀번호</td><td>이름</td><td>이메일</td><td>가입일</td></tr>");
    members.forEach(m -> {
      String row = String.format("<tr><td>%s</td><td>%s</td><td>%s</td><td>%s</td><td>%s</td></tr>", m.getId(),
          m.getPwd(), m.getName(), m.getEmail(), m.getJoinDate());
      writer.print(row);
    });
    writer.print("</table>");
    writer.print("</html></body>");

    writer.close();
  }
}
