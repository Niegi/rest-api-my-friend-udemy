package com.example.restapimyfriendudemy.controller;

import com.example.restapimyfriendudemy.entity.Student;
import com.example.restapimyfriendudemy.request.CreateStudentRequest;
import com.example.restapimyfriendudemy.request.UpdateStudentRequest;
import com.example.restapimyfriendudemy.response.StudentResponse;
import com.example.restapimyfriendudemy.service.StudentService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
public class StudentController {

  private final StudentService studentService;
  private static final String STUDENTS_PATH = "/students";

  public StudentController(StudentService studentService) {
    this.studentService = studentService;
  }

  @GetMapping(path = STUDENTS_PATH)
  public List<StudentResponse> getAllStudents() {
    return studentService.getAllStudents().stream()
      .map(StudentResponse::new)
      .collect(Collectors.toList());
  }

  @PostMapping(path = STUDENTS_PATH)
  public ResponseEntity<StudentResponse> createStudent(@Valid @RequestBody CreateStudentRequest createStudentRequest) {
    Student student = studentService.createStudent(createStudentRequest);
    StudentResponse studentResponse = new StudentResponse(student);
    return ResponseEntity.ok(studentResponse);
  }

  @PutMapping(path = STUDENTS_PATH)
  public ResponseEntity<StudentResponse> updateStudent(@Valid @RequestBody UpdateStudentRequest updateStudentRequest) {
    Student student = studentService.updateStudent(updateStudentRequest);
    StudentResponse studentResponse = new StudentResponse(student);
    return ResponseEntity.ok(studentResponse);
  }

  @DeleteMapping(path = STUDENTS_PATH + "/{id}")
  public ResponseEntity<StudentResponse> deleteStudent(@PathVariable long id) {
    Optional<Student> student = studentService.deleteStudent(id);
    if (student.isPresent()) {
      StudentResponse studentResponse = new StudentResponse(student.get());
      return ResponseEntity.ok(studentResponse);
    }
    return ResponseEntity.notFound().build();
  }

  @GetMapping(path = STUDENTS_PATH + "/{firstName}")
  public List<StudentResponse> getStudentsByFirstName(@PathVariable String firstName) {
    return studentService.getByFirstName(firstName).stream()
      .map(StudentResponse::new)
      .collect(Collectors.toList());
  }

  @GetMapping(path = STUDENTS_PATH + "/{firstName}/{lastName}")
  public List<StudentResponse> getStudentsByFirstNameAndLastName(@PathVariable String firstName, @PathVariable String lastName) {
    return studentService.getByFirstNameAndLastName(firstName, lastName).stream()
      .map(StudentResponse::new)
      .collect(Collectors.toList());
  }
}
