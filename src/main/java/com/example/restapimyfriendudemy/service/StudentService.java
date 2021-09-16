package com.example.restapimyfriendudemy.service;

import com.example.restapimyfriendudemy.entity.Student;
import com.example.restapimyfriendudemy.repository.StudentRepository;
import com.example.restapimyfriendudemy.request.CreateStudentRequest;
import com.example.restapimyfriendudemy.request.UpdateStudentRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {

  StudentRepository studentRepository;

  public StudentService(StudentRepository studentRepository) {
    this.studentRepository = studentRepository;
  }

  public List<Student> getAllStudents() {
    return studentRepository.findAll();
  }

  public Student createStudent(CreateStudentRequest createStudentRequest) {
    Student student = new Student(createStudentRequest);
    student = studentRepository.save(student);
    return student;
  }

  public Student updateStudent(UpdateStudentRequest updateStudentRequest) {
    Student student = studentRepository.findById(updateStudentRequest.getId()).get();

    String firstName = updateStudentRequest.getFirstName();
    String lastName = updateStudentRequest.getLastName();
    String email = updateStudentRequest.getEmail();
    if (firstName != null && !firstName.isEmpty()) {
      student.setFirstName(firstName);
    }
    if (lastName != null && !lastName.isEmpty()) {
      student.setLastName(lastName);
    }
    if (email != null && !email.isEmpty()) {
      student.setEmail(email);
    }

    student = studentRepository.save(student);
    return student;
  }
}
