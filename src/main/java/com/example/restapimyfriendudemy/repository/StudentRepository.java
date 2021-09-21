package com.example.restapimyfriendudemy.repository;

import com.example.restapimyfriendudemy.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {

  List<Student> findByFirstName(String firstName);

  List<Student> findByFirstNameAndLastName(String firstName, String lastName);

  List<Student> findByFirstNameOrLastName(String firstName, String lastName);
}
