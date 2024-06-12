package com.amar.SpringBoot.controller;

import com.amar.SpringBoot.entity.Employee;
import com.amar.SpringBoot.entity.RequestResposeEntity;
import com.amar.SpringBoot.exceptionHandler.EmployeeNotFoundException;
import com.amar.SpringBoot.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class EmployeeController {

    private EmployeeService service;

    @Autowired
    public EmployeeController(EmployeeService service) {
        this.service = service;
    }

    @PostMapping("/employees")
    public ResponseEntity<RequestResposeEntity> createNewEmployee(@RequestBody Employee employee){
        service.createNewEmployee(employee);
        Optional<Employee> employeeById = service.getEmployeeById(employee.getEmpId());
        RequestResposeEntity body = new RequestResposeEntity();
        body.setEmployees(employeeById.stream().toList());
        body.setHttpResponse(HttpStatus.OK.name());

        return new ResponseEntity<>(body,HttpStatus.OK);

    }

    @GetMapping("/employees")
    public ResponseEntity<RequestResposeEntity> getAllEmployee(){
        List<Employee> allEmployees = service.getAllEmployees();
        RequestResposeEntity body = new RequestResposeEntity();
        body.setEmployees(allEmployees);
        body.setHttpResponse(HttpStatus.FOUND.name());

        return new ResponseEntity<>(body,HttpStatus.FOUND);
    }

    @GetMapping("/employees/{empId}")
    public ResponseEntity<RequestResposeEntity> getEmployeeById(@PathVariable int empId){
        Optional<Employee> employeeById = service.getEmployeeById(empId);
        if(employeeById.isPresent()){
            RequestResposeEntity body = new RequestResposeEntity();
            body.setEmployees(employeeById.stream().toList());
            body.setHttpResponse(HttpStatus.FOUND.name());

            return new ResponseEntity<>(body,HttpStatus.FOUND);
        }else {
            throw new EmployeeNotFoundException("Employee with Employee Id - "+empId+ " not found");
        }
    }

    @DeleteMapping("/employees/{empId}")
    public ResponseEntity<RequestResposeEntity> deleteEmployeeById(@PathVariable int empId){
        Optional<Employee> employeeById = service.getEmployeeById(empId);
        if(employeeById.isPresent()){
            service.deleteEmployee(empId);
            RequestResposeEntity body = new RequestResposeEntity();
            body.setEmployees(employeeById.stream().toList());
            body.setHttpResponse(HttpStatus.OK.name());
            return new ResponseEntity<>(body,HttpStatus.OK);
        }else {
            throw new EmployeeNotFoundException("Employee with Employee Id - "+empId+ " not found");
        }
    }

    @PutMapping("/employees")
    public ResponseEntity<RequestResposeEntity> updateEmployee(@RequestBody Employee employee){
//        Optional<Employee> employeeById = service.getEmployeeById(empId);
        if(!(Optional.of(employee.getEmpId()).get() ==0)){
            service.createNewEmployee(employee);
            RequestResposeEntity body = new RequestResposeEntity();
            body.setEmployees(List.of(employee));
            body.setHttpResponse(HttpStatus.OK.name());
            return new ResponseEntity<>(body,HttpStatus.OK);
        }else {
            throw new EmployeeNotFoundException("Please provide the employee Id to update.");
        }
    }
}
