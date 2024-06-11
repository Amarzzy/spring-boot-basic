package com.amar.SpringBoot.repository.impl;

import com.amar.SpringBoot.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
}
