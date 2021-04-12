package com.endsoul.book.web_tech.ch7.ex04.member_add_del;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.stream.Stream;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/member4")
public class MemberServlet extends HttpServlet {

  @Override
  protected void doPost(HttpServletRequest req, HttpServletResponse resp)
      throws ServletException, IOException {
    doHandle(req, resp);
  }

  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp)
      throws ServletException, IOException {
    doHandle(req, resp);
  }

  private void doHandle(HttpServletRequest req, HttpServletResponse resp)
      throws ServletException, IOException {
    req.setCharacterEncoding("utf-8");
    resp.setContentType("text/html; charset=UTF-8");

    MemberDAO dao = new MemberDAO();
    String command = req.getParameter("command");
    if (command != null && command.equals("addMember")) {
      String _id=req.getParameter("id");
      String _pwd=req.getParameter("pwd");
      String _name=req.getParameter("name");
      String _email=req.getParameter("email");

      MemberVO vo = new MemberVO();
      vo.setId(_id);
      vo.setPwd(_pwd);
      vo.setName(_name);
      vo.setEmail(_email);
      dao.addMember(vo);
    } else if (command != null && command.equals("delMember")) {
      String id = req.getParameter("id");
      dao.delMember(id);
    }

    Stream<MemberVO> members = dao.listMembers().stream();

    PrintWriter writer = resp.getWriter();
    writer.print("<html><body>");
    writer.print("<table border='1'><tr align='center' bgcolor='lightgreen'><td>아이디</td><td>비밀번호</td><td>이름</td><td>이메일</td><td>가입일</td><td>삭제</td></tr>");
    members.forEach(m -> {
      String row = String.format("<tr><td>%s</td><td>%s</td><td>%s</td><td>%s</td><td>%s</td><td><a href='/member4?command=delMember&id=%s'>삭제</a></td></tr>", m.getId(),
          m.getPwd(), m.getName(), m.getEmail(), m.getJoinDate(), m.getId());
      writer.print(row);
    });
    writer.print("</table>");
    writer.print("</html></body>");

    writer.close();
  }
}
