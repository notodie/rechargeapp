package com.giift.rechargeapp.controller;


import com.giift.rechargeapp.model.Country;
import com.giift.rechargeapp.model.Operator;
import com.giift.rechargeapp.service.CountryService;
import com.giift.rechargeapp.service.OperatorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/countries")
public class CountryController {

    @Autowired
    private CountryService countryService;

    @Autowired
    private OperatorService operatorService;

    // Obtenir la liste des pays
    @GetMapping("/country")
    public List<Country> getCountries() {
        return countryService.getAllCountries(); // Implémentez cette méthode dans le service
    }

    // Obtenir les opérateurs par pays
    @GetMapping("/{countryId}/operators")
    public List<Operator> getOperatorsByCountry(@PathVariable String countryId) {
        return operatorService.getOperatorsByCountry(countryId); // Implémentez cette méthode dans le service
    }
}