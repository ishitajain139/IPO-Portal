package com.app.ipo.service;

import com.app.ipo.model.RejectedAudit;

import java.util.List;

public interface RejectedAuditService {
    List<RejectedAudit> getRejectedAuditByVpa(String vpa);
    List<RejectedAudit> getRejectedAuditByPan(String pan);
    List<RejectedAudit> getRejectedAuditBySym(String sym);
}