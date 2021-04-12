package com.endsoul.book.web_tech.ch7.ex03.data_source;

import java.sql.Date;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class MemberVO {
  private final String id;
  private final String pwd;
  private final String name;
  private final String email;
  private final Date joinDate;
}
