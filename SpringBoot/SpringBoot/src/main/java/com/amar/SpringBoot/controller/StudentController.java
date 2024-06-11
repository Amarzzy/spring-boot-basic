package com.amar.SpringBoot.controller;


import com.amar.SpringBoot.entity.RequestResposeEntity;
import com.amar.SpringBoot.entity.Student;
import com.amar.SpringBoot.exceptionHandler.StudentNotFoundException;
import com.amar.SpringBoot.repository.StudentDAO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class StudentController {

    StudentDAO dao;

    public StudentController(StudentDAO dao) {
        this.dao = dao;
    }


    @PostMapping("/students")
    public ResponseEntity<RequestResposeEntity> addStudent(@RequestBody Student student) {
        dao.save(student);
        RequestResposeEntity body = new RequestResposeEntity();
        body.setStudent(Arrays.asList(student));
        body.setHttpResponse(HttpStatus.CREATED.toString());
        return new ResponseEntity<>(body, HttpStatus.CREATED);
    }

    @GetMapping("/students/{studentId}")
    public ResponseEntity<RequestResposeEntity> getStudent(@PathVariable String studentId) {
        Optional<Student> singleStudent = dao.getSingleStudent(studentId);
        if (singleStudent.isPresent()) {
            RequestResposeEntity body = new RequestResposeEntity();
            body.setStudent(Arrays.asList(singleStudent.get()));
            body.setHttpResponse(HttpStatus.FOUND.toString());
            return new ResponseEntity<>(body, HttpStatus.FOUND);
        } else {
            throw new StudentNotFoundException("Student with Id -" + studentId + " not found");
        }
    }

    @GetMapping("/students")
    public ResponseEntity<RequestResposeEntity> getAllStudent() {
        List<Student> allStudent = dao.getAllStudent();
        RequestResposeEntity body = new RequestResposeEntity();
        body.setStudent(allStudent);
        body.setHttpResponse(HttpStatus.FOUND.toString());
        return new ResponseEntity<>(body, HttpStatus.FOUND);
    }


}
