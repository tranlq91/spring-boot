package com.example.learn.spring;

import static org.junit.jupiter.api.Assertions.*;

import com.example.learn.spring.entity.AuditLog;
import com.example.learn.spring.entity.Employee;
import com.example.learn.spring.repository.AuditRepository;
import com.example.learn.spring.repository.EmployeeRepository;
import com.example.learn.spring.service.AuditService;
import com.example.learn.spring.service.EmployeeService;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@SpringBootTest
class TransactionRollbackTest {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private AuditRepository auditRepository;

    @Autowired
    private EmployeeService employeeService;

    @Autowired
    private AuditService auditService;

    @BeforeEach
    void clear() {
        employeeRepository.deleteAll();
        auditRepository.deleteAll();
    }

    @Test
    void testOuterTransactionCommits_InnerTransactionFails_REQUIRES_NEW() {
        // Run processEmployee() with audit failure
        employeeService.processEmployee(true);

        // Employee should be committed
        List<Employee> employees = employeeRepository.findAll();
        assertEquals(1, employees.size());

        // Audit log should NOT be committed due to rollback
        List<AuditLog> logs = auditRepository.findAll();
        assertEquals(0, logs.size());
    }

    @Test
    void testBothTransactionsCommitSuccessfully() {
        employeeService.processEmployee(false);

        // Both Employee and Audit Log should be committed
        List<Employee> employees = employeeRepository.findAll();
        List<AuditLog> logs = auditRepository.findAll();

        assertEquals(1, employees.size());
        assertEquals(1, logs.size());
    }
}
