package com.endsoul.servlets;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "FormServlet", urlPatterns = "/calculateServlet")
public class FormServlet extends HttpServlet {

  @Override
  protected void doPost(HttpServletRequest req, HttpServletResponse resp)
      throws ServletException, IOException {
    String height = req.getParameter("height");
    String weight = req.getParameter("weight");

    try {
      double bmi = calculateBMI(Double.parseDouble(weight), Double.parseDouble(height));

      req.setAttribute("bmi", bmi);
      resp.setHeader("Test", "Success");
      resp.setHeader("BMI", String.valueOf(bmi));

      RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/jsp/index.jsp");
      dispatcher.forward(req, resp);
    } catch (Exception e) {
      resp.sendRedirect("index.jsp");
    }
  }

  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp)
      throws ServletException, IOException {
    RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/jsp/index.jsp");
    dispatcher.forward(req, resp);
  }

  private Double calculateBMI(Double weight, Double height) {
    return weight / (height * height);
  }
}
