package com.giift.rechargeapp.controller;


import com.giift.rechargeapp.model.Country;
import com.giift.rechargeapp.model.Operator;
import com.giift.rechargeapp.service.CountryService;
import com.giift.rechargeapp.service.OperatorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/allCountries")
public class ApiController {

    @Autowired
    private CountryService countryService;

    @Autowired
    private OperatorService operatorService;

    @GetMapping("/countries")
    public List<Country> getAllCountries() {
        return countryService.getAllCountries();
    }

    @GetMapping("/countries/{countryId}/operators")
    public List<Operator> getOperatorsByCountry(@PathVariable String countryId) {
        return operatorService.getOperatorsByCountry(countryId);
    }
}