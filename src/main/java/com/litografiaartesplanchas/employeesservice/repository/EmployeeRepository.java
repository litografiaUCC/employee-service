package com.litografiaartesplanchas.employeesservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.litografiaartesplanchas.employeesservice.model.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer>{
    boolean existsByEmail(String email);
    boolean existsByNumberDocument(String numberDocument);

}
