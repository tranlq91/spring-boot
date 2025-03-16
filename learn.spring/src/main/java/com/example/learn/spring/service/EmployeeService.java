package com.example.learn.spring.service;

import com.example.learn.spring.entity.Employee;
import com.example.learn.spring.repository.EmployeeRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class EmployeeService {
    private final EmployeeRepository employeeRepository;

    private final AuditService auditService;

    public EmployeeService(EmployeeRepository employeeRepository, AuditService auditService) {
        this.employeeRepository = employeeRepository;
        this.auditService = auditService;
    }
    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    public Employee addEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }

    @Transactional
    public void processEmployee(boolean failAudit) {
        Employee emp = new Employee(101L, "John Doe", "IT");
        employeeRepository.save(emp);

        try {
            auditService.logTransaction(emp.getId(), failAudit);
        } catch (Exception e) {
            // Catch the error to prevent outer transaction rollback
            System.out.println("Audit transaction failed, but Employee transaction continues.");
        }
    }
}
