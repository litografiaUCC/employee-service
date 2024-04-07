package com.litografiaartesplanchas.employeesservice.service;

import java.util.List;
import java.util.Optional;

import com.litografiaartesplanchas.employeesservice.model.Employee;
import com.litografiaartesplanchas.employeesservice.model.Role;
import com.litografiaartesplanchas.employeesservice.model.TypeDocument;
import com.litografiaartesplanchas.employeesservice.repository.EmployeeRepository;
import com.litografiaartesplanchas.employeesservice.repository.RoleRepository;
import com.litografiaartesplanchas.employeesservice.repository.TypeDocumentRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;
    @Autowired
    private RoleRepository roleRepository;
    @Autowired
    private TypeDocumentRepository typeDocumentRepository;


    public List<Employee> getAll() throws Exception {
        try {
            return employeeRepository.findAll();
        } catch (Exception e) {
            throw new Exception("Error occurred while fetching all employees: " + e.getMessage());
        }
    }
    
    public Optional<Employee> getClientById(Integer id) throws Exception {
        try {
            return employeeRepository.findById(id);
        } catch (Exception e) {
            throw new Exception("Error occurred while fetching employee with id " + id + ": " + e.getMessage());
        }
    }
    
    public void registerEmployee(Employee employee) throws Exception {

        if (employeeRepository.existsByEmail(employee.getEmail())) {
            throw new Exception("The email address is already in use");
        }
        
        if (employeeRepository.existsByNumberDocument(employee.getNumberDocument())) {
            throw new Exception("The document number is already in use");
        }

        try {
            employee.setIsActive(true);
            employeeRepository.save(employee);
        } catch (Exception e) {
            throw new Exception("Error occurred while registering employee: " + e.getMessage());
        }
    }

    public void updateEmployeeById(Employee updatedEmployee) throws Exception {
        try {
            Optional<Employee> optional = employeeRepository.findById(updatedEmployee.getId());
            if (optional.isEmpty()) {
                throw new Exception("Employee not found");
            }
            Employee employee = optional.get();
            if (updatedEmployee.getName() != null) employee.setName(updatedEmployee.getName());
            if (updatedEmployee.getLastname() != null) employee.setLastname(updatedEmployee.getLastname());
            if (updatedEmployee.getEmail() != null) employee.setEmail(updatedEmployee.getEmail());
            if (updatedEmployee.getPassword() != null) employee.setPassword(updatedEmployee.getPassword());
            if (updatedEmployee.getPhone() != null) employee.setPhone(updatedEmployee.getPhone());
            if (updatedEmployee.getPhoto() != null) employee.setPhoto(updatedEmployee.getPhoto());
            if (updatedEmployee.getNumberDocument() != null) employee.setNumberDocument(updatedEmployee.getNumberDocument());
            if (updatedEmployee.getTypeDocument() != null) {
                Optional<TypeDocument> typeDocumentOptional = typeDocumentRepository.findById(updatedEmployee.getTypeDocument().getId());
                if (typeDocumentOptional.isEmpty()) {
                    throw new Exception("Type Document not found");
                }
                employee.setTypeDocument(typeDocumentOptional.get());
            }
            if (updatedEmployee.getRole() != null) {
                Optional<Role> roleOptional = roleRepository.findById(updatedEmployee.getRole().getId_role());
                if (roleOptional.isEmpty()) {
                    throw new Exception("Role not found");
                }
                employee.setRole(roleOptional.get());
            }
            employeeRepository.save(employee);
        } catch (Exception e) {
            throw new Exception("Error occurred while updating employee: " + e.getMessage());
        }
    }    
}

