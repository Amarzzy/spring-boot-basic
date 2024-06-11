package com.amar.SpringBoot.entity;

import lombok.Data;

import java.util.List;

@Data
public class RequestResposeEntity {
    String httpResponse;

    List<Student> student;
}
