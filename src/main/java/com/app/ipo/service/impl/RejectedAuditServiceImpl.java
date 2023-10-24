package com.app.ipo.service.impl;

import com.app.ipo.model.RejectedAudit;
import com.app.ipo.repository.RejectedAuditRepository;
import com.app.ipo.service.RejectedAuditService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RejectedAuditServiceImpl implements RejectedAuditService {
    private final RejectedAuditRepository rejectedAuditRepository;

    @Autowired
    public RejectedAuditServiceImpl(RejectedAuditRepository rejectedAuditRepository) {
        this.rejectedAuditRepository = rejectedAuditRepository;
    }

    @Override
    public List<RejectedAudit> getRejectedAuditByVpa(String vpa) {
        return rejectedAuditRepository.findByVpa(vpa);
    }

    @Override
    public List<RejectedAudit> getRejectedAuditByPan(String pan) {
        return rejectedAuditRepository.findByPan(pan);
    }

    @Override
    public List<RejectedAudit> getRejectedAuditBySym(String sym) {
        return rejectedAuditRepository.findBySym(sym);
    }
}
