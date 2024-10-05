package com.giift.rechargeapp.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;

@Service
public class ReloadlyService {

    @Value("${reloadly.api.key}")
    private String apiKey;

    private final RestTemplate restTemplate;

    public ReloadlyService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public String rechargePhone(String phoneNumber, String amount, String operatorId, String email) {
        String url = "https://api.reloadly.com/recharge"; // L'URL de l'API de recharge

        HttpHeaders headers = new HttpHeaders();
        headers.set("Authorization", "Bearer " + apiKey);
        headers.set("Content-Type", "application/json");

        String body = String.format("{\"to\": \"%s\", \"amount\": \"%s\", \"operatorId\": \"%s\", \"email\": \"%s\"}",
                phoneNumber, amount, operatorId, email);

        HttpEntity<String> entity = new HttpEntity<>(body, headers);
        ResponseEntity<String> response = restTemplate.postForEntity(url, entity, String.class);

        return response.getBody(); // Renvoie la réponse de l'API
    }
}