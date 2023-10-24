package com.app.ipo.repository;

import com.app.ipo.model.MerchantDetailsEntity;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MerchantDetailsRepository extends JpaRepository<MerchantDetailsEntity, Long> {
	  List<MerchantDetailsEntity> findByVpa(String vpa);
	    List<MerchantDetailsEntity> findByPan(String pan);
	    List<MerchantDetailsEntity> findBySym(String sym);

}
