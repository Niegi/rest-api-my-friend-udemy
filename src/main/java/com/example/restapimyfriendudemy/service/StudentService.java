package com.example.restapimyfriendudemy.service;

import com.example.restapimyfriendudemy.entity.Student;
import com.example.restapimyfriendudemy.repository.StudentRepository;
import com.example.restapimyfriendudemy.request.CreateStudentRequest;
import com.example.restapimyfriendudemy.request.InQueryRequest;
import com.example.restapimyfriendudemy.request.UpdateStudentRequest;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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

  public Optional<Student> deleteStudent(Long id) {
    Optional<Student> student = studentRepository.findById(id);
    if (student.isPresent()) {
      studentRepository.deleteById(id);
    }
    return student;
  }

  public List<Student> getByFirstName(String firstName) {
    return studentRepository.findByFirstName(firstName);
  }

  public List<Student> getByFirstNameAndLastName(String firstName, String lastName) {
    return studentRepository.findByFirstNameAndLastName(firstName, lastName);
  }

  public List<Student> getByFirstNameOrLastName(String firstName, String lastName) {
    return studentRepository.findByFirstNameOrLastName(firstName, lastName);
  }

  public List<Student> getByFirstNameIn(InQueryRequest inQueryRequest) {
    return studentRepository.findByFirstNameIn(inQueryRequest.getFirstNames());
  }
}
