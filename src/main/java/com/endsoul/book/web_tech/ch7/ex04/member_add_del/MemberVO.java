package com.endsoul.book.web_tech.ch7.ex04.member_add_del;

import java.sql.Date;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

// TODO: lombok 으로 joinDate 만 제외한 생성자와 전체 필드 생성자 둘 다 가능?
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class MemberVO {
  private String id;
  private String pwd;
  private String name;
  private String email;
  private Date joinDate;
}
