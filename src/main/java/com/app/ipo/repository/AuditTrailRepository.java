package com.app.ipo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.app.ipo.model.AuditTrail;

@Repository
public interface AuditTrailRepository extends JpaRepository<AuditTrail, Integer> {
    // Define custom query methods here if needed
}
