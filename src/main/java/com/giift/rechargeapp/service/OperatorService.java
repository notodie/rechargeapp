package com.giift.rechargeapp.service;


import com.giift.rechargeapp.model.Operator;
import com.giift.rechargeapp.repository.OperatorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OperatorService {

    @Autowired
    private OperatorRepository operatorRepository;

    public List<Operator> getOperatorsByCountry(String countryId) {
        return operatorRepository.findByCountryId(countryId); // Remplacez par la logique pour récupérer les opérateurs
    }
}