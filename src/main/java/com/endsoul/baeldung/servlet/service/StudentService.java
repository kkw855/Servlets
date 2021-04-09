package com.endsoul.baeldung.servlet.service;

import com.endsoul.baeldung.servlet.model.Student;
import io.vavr.control.Option;

public class StudentService {
  public Option<Student> getStudent(int id) {
    switch (id) {
      case 1:
        return Option.of(new Student(1, "John", "Doe"));
      case 2:
        return Option.of(new Student(2, "Jane", "Goodall"));
      case 3:
        return Option.of(new Student(3, "Max", "Born"));
      default:
        return Option.none();
    }
  }
}
