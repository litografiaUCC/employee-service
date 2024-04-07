package com.litografiaartesplanchas.employeesservice.controller;


import com.litografiaartesplanchas.employeesservice.model.Employee;
import com.litografiaartesplanchas.employeesservice.service.EmployeeService;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/employee")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @PostMapping("/register")
    public ResponseEntity<?> registerEmployee(@RequestBody Employee employee) {
    try {
        employeeService.registerEmployee(employee);
        return ResponseEntity.ok().body("{\"status\": 200, \"message\": \"ok\"}");
    } catch (Exception e) {
        e.printStackTrace(); 
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("{\"status\": 400, \"message\": \"" + e.getMessage() + "\"}");
    }
}
    @GetMapping("/")
    public ResponseEntity<?> getAllEmployees() {
        try {
            List<Employee> employees = employeeService.getAll();
            if (employees.isEmpty()) {
                return ResponseEntity.noContent().build();
            }
            return ResponseEntity.ok(employees);
        } catch(Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("{\"status\": 400,\"message\": \"Something Went Wrong\"}");
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getEmployeeById(@PathVariable Integer id) {
    try {
        Optional<Employee> employeeOptional = employeeService.getClientById(id);
        if (employeeOptional.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("{\"status\": 404, \"message\": \"Not Found\"}");
        }
        Employee employee = employeeOptional.get();
        return ResponseEntity.ok(employee);
    } catch (Exception e) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("{\"status\": 400, \"message\": \"" + e.getMessage() + "\"}");
    }
}
}


