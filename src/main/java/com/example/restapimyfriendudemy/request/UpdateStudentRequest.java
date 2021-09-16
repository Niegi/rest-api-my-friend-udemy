package com.example.restapimyfriendudemy.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;

@Getter
@Setter
public class UpdateStudentRequest {

  @NotNull(message = "Student id is required")
  private Long id;

  @JsonProperty("first_name")
  private String firstName;

  private String lastName;

  private String email;
}
