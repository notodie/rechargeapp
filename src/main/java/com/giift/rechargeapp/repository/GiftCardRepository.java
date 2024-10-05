package com.giift.rechargeapp.repository;

import com.giift.rechargeapp.model.GiftCard;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GiftCardRepository extends JpaRepository<GiftCard, Long> {
    // Add custom query methods if needed
}
