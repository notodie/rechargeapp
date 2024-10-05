package com.giift.rechargeapp.repository;

import com.giift.rechargeapp.model.Recharge;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RechargeRepository extends JpaRepository<Recharge, Long> {
    // Add custom query methods if needed
}