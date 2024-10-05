package com.giift.rechargeapp.repository;

import com.giift.rechargeapp.model.Operator;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface OperatorRepository extends JpaRepository<Operator, String> {
    List<Operator> findByCountryId(String countryId); // Méthode pour récupérer les opérateurs par ID de pays
}