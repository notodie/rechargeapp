package com.giift.rechargeapp.service;


import com.giift.rechargeapp.model.Country;
import com.giift.rechargeapp.repository.CountryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CountryService {

    @Autowired
    private CountryRepository countryRepository;

    public List<Country> getAllCountries() {
        return countryRepository.findAll(); // Remplacez par la logique pour récupérer les pays
    }
}