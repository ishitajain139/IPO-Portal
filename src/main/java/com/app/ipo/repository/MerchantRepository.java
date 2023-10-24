package com.app.ipo.repository;

import com.app.ipo.model.MerchantEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface MerchantRepository extends JpaRepository<MerchantEntity, Long> {

    List<MerchantEntity> findMerchantByVpa(String vpa);

    @Query(value = "SELECT * FROM merchant_details m ORDER BY User_Id DESC LIMIT :limit", nativeQuery = true)
    List<MerchantEntity> findAllMerchant(@Param("limit") Integer limit);

    @Query(value = "SELECT * FROM merchant_details m WHERE m.Status = :status ORDER BY User_Id DESC LIMIT :limit", nativeQuery = true)
    List<MerchantEntity> findAllMerchantByStatus(@Param("status") String status, @Param("limit") Integer limit);

    @Query(value = "SELECT * FROM merchant_details m WHERE m.Status IN :status ORDER BY User_Id DESC LIMIT :limit", nativeQuery = true)
    List<MerchantEntity> findAllMerchantByProcessedStatus(@Param("status") List<String> status, @Param("limit") Integer limit);
    
    List<MerchantEntity> findByVpa(String vpa);
    List<MerchantEntity> findByPan(String pan);
    List<MerchantEntity> findBySym(String sym);
}
