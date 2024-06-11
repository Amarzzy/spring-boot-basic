package com.amar.SpringBoot.exceptionHandler;

import com.amar.SpringBoot.entity.ExceptionResposeEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler
    public ResponseEntity<ExceptionResposeEntity> handleStudentNotFoundException(StudentNotFoundException exception) {
        ExceptionResposeEntity body = new ExceptionResposeEntity();
        body.setHttpResponse(HttpStatus.NOT_FOUND.toString());
        body.setMessage(exception.getMessage());
        body.setTimeStamp(System.currentTimeMillis());
        return new ResponseEntity<>(body, HttpStatus.NOT_FOUND);
    }
}
