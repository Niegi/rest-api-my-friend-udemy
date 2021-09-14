package com.example.restapimyfriendudemy.service;

import com.example.restapimyfriendudemy.entity.Student;
import com.example.restapimyfriendudemy.repository.StudentRepository;
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
}
