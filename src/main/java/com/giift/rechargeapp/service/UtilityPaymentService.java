package com.giift.rechargeapp.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;

@Service
public class UtilityPaymentService {

    @Value("${reloadly.api.key}")
    private String apiKey;

    private final RestTemplate restTemplate;

    public UtilityPaymentService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public String payUtility(String utilityType, String accountNumber, String amount) {
        String url = "https://api.reloadly.com/utilities/pay"; // L'URL pour le paiement des services publics

        HttpHeaders headers = new HttpHeaders();
        headers.set("Authorization", "Bearer " + apiKey);
        headers.set("Content-Type", "application/json");

        String body = String.format("{\"utilityType\": \"%s\", \"accountNumber\": \"%s\", \"amount\": \"%s\"}",
                utilityType, accountNumber, amount);

        HttpEntity<String> entity = new HttpEntity<>(body, headers);
        ResponseEntity<String> response = restTemplate.postForEntity(url, entity, String.class);

        return response.getBody(); // Renvoie la réponse de l'API pour le paiement
    }
}