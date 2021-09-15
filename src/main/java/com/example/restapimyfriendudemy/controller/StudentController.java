package com.example.restapimyfriendudemy.controller;

import com.example.restapimyfriendudemy.response.StudentResponse;
import com.example.restapimyfriendudemy.service.StudentService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
public class StudentController {

  StudentService studentService;

  public StudentController(StudentService studentService) {
    this.studentService = studentService;
  }

  @GetMapping("/students")
  public List<StudentResponse> getAllStudents() {
    return studentService.getAllStudents().stream()
      .map(StudentResponse::new)
      .collect(Collectors.toList());
  }
}
