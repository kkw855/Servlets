package com.endsoul.baeldung.servlet.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class Student {
  private int id;
  private String firstName;
  private String lastName;
}
