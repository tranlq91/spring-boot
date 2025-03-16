package com.example.learn.spring.service;

import com.example.learn.spring.entity.AuditLog;
import com.example.learn.spring.repository.AuditRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
public class AuditService {
    private final AuditRepository auditRepository;

    public AuditService(AuditRepository auditRepository) {
        this.auditRepository = auditRepository;
    }

    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public void logTransaction(Long empId, boolean fail) {
        AuditLog log = new AuditLog(null, empId, "Employee Created");
        auditRepository.save(log);

        if (fail) {
            throw new RuntimeException("Simulated failure in audit transaction");
        }
    }
}
