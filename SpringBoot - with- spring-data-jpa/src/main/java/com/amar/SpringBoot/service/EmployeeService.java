package com.amar.SpringBoot.service;

import com.amar.SpringBoot.entity.Employee;
import com.amar.SpringBoot.repository.impl.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {

    private EmployeeRepository repository;

    @Autowired
    public EmployeeService(EmployeeRepository repository) {
        this.repository = repository;
    }

    public List<Employee> getAllEmployees(){
        return repository.findAll();
    }

    public Optional<Employee> getEmployeeById(int empId){
        return repository.findById(empId);
    }

    public void createNewEmployee(Employee employee) {
        repository.save(employee);
    }

    public void deleteEmployee(int empId) {
        repository.deleteById(empId);
    }
}
