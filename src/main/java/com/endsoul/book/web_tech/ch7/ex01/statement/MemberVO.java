package com.endsoul.book.web_tech.ch7.ex01.statement;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.sql.Date;

@AllArgsConstructor
@Getter
public class MemberVO {
  private final String id;
  private final String pwd;
  private final String name;
  private final String email;
  private final Date joinDate;
}
