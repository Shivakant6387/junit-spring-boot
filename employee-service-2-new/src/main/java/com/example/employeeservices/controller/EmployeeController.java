package com.example.employeeservices.controller;

import com.example.employeeservices.entity.Employee;
import com.example.employeeservices.repository.EmployeeRepository;
import com.example.employeeservices.response.EmployeeResponse;
import com.example.employeeservices.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;
    @GetMapping("/employees/{id}")
    ResponseEntity<EmployeeResponse >getEmployeeDetail(@PathVariable("id")int id){
         EmployeeResponse employeeResponse=employeeService.getEmployeeById(id);
        return ResponseEntity.status(HttpStatus.OK).body(employeeResponse);
    }
}
