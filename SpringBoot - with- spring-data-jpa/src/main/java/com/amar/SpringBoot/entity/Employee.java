package com.amar.SpringBoot.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "employee")
@Data
public class Employee {

    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    int empId;

    @Column(name = "first_name")
    String firstName;

    @Column(name = "last_name")
    String latName;

    @Column(name = "email")
    String email;
}
