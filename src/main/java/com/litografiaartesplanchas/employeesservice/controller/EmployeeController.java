package com.litografiaartesplanchas.employeesservice.controller;


import com.litografiaartesplanchas.employeesservice.model.Employee;
import com.litografiaartesplanchas.employeesservice.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
}


