package com.app.ipo.repository;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import com.app.ipo.model.AdminEntity;

public interface AdminRepository extends JpaRepository<AdminEntity, Long> {
    Optional<AdminEntity> findByAdminEmailAndAdminPassword(String adminEmail, String adminPassword);
}
