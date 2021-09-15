package com.example.restapimyfriendudemy.entity;

import com.example.restapimyfriendudemy.request.CreateStudentRequest;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@NoArgsConstructor
@Table(name = "student")
public class Student {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id")
  private Long id;

  @Column(name = "first_name")
  private String firstName;

  @Column(name = "last_name")
  private String lastName;

  @Column(name = "email")
  private String email;

  public Student(CreateStudentRequest request) {
    this.firstName = request.getFirstName();
    this.lastName = request.getLastName();
    this.email = request.getEmail();
  }
}
