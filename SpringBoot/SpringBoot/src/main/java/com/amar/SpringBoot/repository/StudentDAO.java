package com.amar.SpringBoot.repository;

import com.amar.SpringBoot.entity.Student;

import java.util.List;
import java.util.Optional;


public interface StudentDAO {

     //Create
     void save(Student student);

     //Read
     Optional<Student> getSingleStudent(int studentId);

     List<Student> getAllStudent();

     //Update
     Student updateStudent(Student student);

     //Delete
     void deleteStudent(Student student);



}
