package com.amar.SpringBoot.repository;

import com.amar.SpringBoot.entity.Student;

import java.util.List;
import java.util.Optional;


public interface StudentDAO {

     //Create
     void save(Student student);

     //Read
     Optional<Student> getSingleStudent(String studentId);

     List<Student> getAllStudent();

     //Update
     int updateStudent(Student student, String fName, String lName);

     //Delete
     int deleteStudent();



}
