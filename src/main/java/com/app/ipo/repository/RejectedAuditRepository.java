package com.app.ipo.repository;

import com.app.ipo.model.RejectedAudit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RejectedAuditRepository extends JpaRepository<RejectedAudit, Integer> {
    List<RejectedAudit> findByVpa(String vpa);
    List<RejectedAudit> findByPan(String pan);
    List<RejectedAudit> findBySym(String sym);
}
