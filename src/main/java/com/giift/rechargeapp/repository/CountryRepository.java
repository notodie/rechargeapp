package com.giift.rechargeapp.repository;

import com.giift.rechargeapp.model.Country;
import org.springframework.data.jpa.repository.JpaRepository;


public interface CountryRepository extends JpaRepository<Country, String> {
    // Ajoutez des méthodes de requête personnalisées si nécessaire
}