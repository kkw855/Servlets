package com.endsoul.baeldung.servlet.controller;

import com.endsoul.baeldung.servlet.model.Student;
import com.endsoul.baeldung.servlet.service.StudentService;
import io.vavr.control.Option;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "StudentServlet", urlPatterns = "/student-record")
public class StudentServlet extends HttpServlet {

  private final StudentService studentService = new StudentService();

  private void processRequest(HttpServletRequest req, HttpServletResponse resp)
      throws ServletException, IOException {
    String studentId = req.getParameter("id");

    if (studentId != null) {
      int id = Integer.parseInt(studentId);
      Option<Student> student = studentService.getStudent(id);
      if (student.isDefined()) {
        req.setAttribute("studentRecord", student.get());
      }
    }

    RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/jsp/student-record.jsp");
    dispatcher.forward(req, resp);
  }

  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp)
      throws ServletException, IOException {
    processRequest(req, resp);
  }

  @Override
  protected void doPost(HttpServletRequest req, HttpServletResponse resp)
      throws ServletException, IOException {
    processRequest(req, resp);
  }
}
