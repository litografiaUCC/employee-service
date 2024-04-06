package com.litografiaartesplanchas.employeesservice.service;

import java.util.List;
import java.util.Optional;

import com.litografiaartesplanchas.employeesservice.model.Employee;
import com.litografiaartesplanchas.employeesservice.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeService {

    @Autowired
    private final EmployeeRepository employeeRepository;

    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    public List<Employee> getAll(){
        return employeeRepository.findAll();
    }

    public Optional<Employee> getClientById(Integer id) {
		return employeeRepository.findById(id);
    }
    
    public void registerEmployee(Employee employee) throws Exception {

        if (employeeRepository.existsByEmail(employee.getEmail())) {
            throw new Exception("The email address is already in use");
        }
        
        if (employeeRepository.existsByNumberDocument(employee.getNumberDocument())) {
            throw new Exception("The document number is already in use");
        }

        try {
            employeeRepository.save(employee);
        } catch (Exception e) {
            throw new Exception("Error occurred while registering employee: " + e.getMessage());
        }
    }
}

