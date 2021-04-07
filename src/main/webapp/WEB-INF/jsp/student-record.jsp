<%@ page import="com.endsoul.model.Student" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
  <title>Student Record</title>
</head>
<body>
  <%
    if (request.getAttribute("studentRecord") != null) {
      Student student = (Student) request.getAttribute("studentRecord");
  %>

  <h1>Student Record</h1>
  <div>
    ID:
    <%=student.getId()%></div>
  <div>
    First Name:
    <%=student.getFirstName()%></div>
  <div>
    Last Name:
    <%=student.getLastName()%></div>

  <%
    } else {
  %>
  <h1>No Student record found.</h1>
  <%
    }
  %>
</body>
</html>
