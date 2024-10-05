package com.giift.rechargeapp.repository;

import com.giift.rechargeapp.model.UtilityPayment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UtilityPaymentRepository extends JpaRepository<UtilityPayment, Long> {
    // Add custom query methods if needed
}