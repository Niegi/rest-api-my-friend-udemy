package com.example.restapimyfriendudemy.response;

import com.example.restapimyfriendudemy.entity.Student;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class StudentResponse {

  private long id;

  @JsonProperty("first_name")
  private String firstName;

  private String lastName;

  private String email;

  private String fullName;

  public StudentResponse(Student student) {
    this.id = student.getId();
    this.firstName = student.getFirstName();
    this.lastName = student.getLastName();
    this.email = student.getEmail();
    this.fullName = student.getFirstName() + " " + student.getLastName();
  }
}
