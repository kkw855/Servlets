package com.endsoul.book.web_tech.ch6.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/calc")
public class CalcServlet extends HttpServlet {
  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp)
      throws ServletException, IOException {
    req.setCharacterEncoding("utf-8");
    resp.setContentType("text/html; charset=utf-8");
    PrintWriter writer = resp.getWriter();
    String command = req.getParameter("command");
    String won = req.getParameter("won");
    String operator = req.getParameter("operator");

    System.out.println("command: " + command);

    writer.print("<html>");
    if (command != null && command.equals("calculate")) {
      // TODO: won 변수가 null 일 때 예외 처리
      String result = calculate(Double.parseDouble(won), operator);
      writer.print("<p style='font-size=10px'>변환결과</p>");
      writer.print("<p style='font-size=10'>" + result + "</p>");
      writer.print("<a href='/calc'>환율 계산기</a>");
    } else {
      writer.print("<title>환율계산기</title>");
      writer.print("<p>환율 계산기</p>");
      writer.print("<form name='frmCalc' method='get' action='calc'>");
      writer.print("원화: <input type='text' name='won' size=10 />");
      writer.print("<select name='operator'>");
      writer.print("<option value='dollar'>달러</option>");
      writer.print("<option value='en'>엔화</option>");
      writer.print("<option value='wian'>위안</option>");
      writer.print("<option value='pound'>파운드</option>");
      writer.print("<option value='euro'>유로</option>");
      writer.print("</select>");
      writer.print("<input type='hidden' name='command' value='calculate' />");
      writer.print("<input type='submit' value='변환' />");
      writer.print("</form>");
    }
    writer.print("</html>");

    writer.close();
  }

  private String calculate(double won, String operator) {
    // TODO: 클래스 static 멤버와 함수 내의 final 차이
    final double USD_RATE = 1124.70;
    final double JPY_RATE = 10.113;
    final double CNY_RATE = 163.30;
    final double GBP_RATE = 1444.35;
    final double EUR_RATE = 1295.97;

    // TODO: 동일한 반복 코드 제거
    String result;
    switch (operator) {
      case "dollar":
        result = String.format("%.6f", won / USD_RATE);
        break;
      case "en":
        result = String.format("%.6f", won / JPY_RATE);
        break;
      case "wian":
        result = String.format("%.6f", won / CNY_RATE);
        break;
      case "pound":
        result = String.format("%.6f", won / GBP_RATE);
        break;
      case "euro":
        result = String.format("%.6f", won / EUR_RATE);
        break;
      default:
        result = "변환 오류";
    }

    return result;
  }
}
