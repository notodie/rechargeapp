package com.giift.rechargeapp.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;

@Service
public class GiftCardService {

    @Value("${reloadly.api.key}")
    private String apiKey;

    private final RestTemplate restTemplate;

    public GiftCardService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public Object getAllGiftCards() {
        String url = "https://api.reloadly.com/gift-cards"; // L'URL de l'API des cartes cadeaux

        HttpHeaders headers = new HttpHeaders();
        headers.set("Authorization", "Bearer " + apiKey);
        headers.set("Content-Type", "application/json");

        HttpEntity<String> entity = new HttpEntity<>(headers);
        ResponseEntity<Object> response = restTemplate.exchange(url, HttpMethod.GET, entity, Object.class);

        return response.getBody(); // Renvoie la liste des cartes cadeaux
    }

    public String purchaseGiftCard(String brand, String amount, String recipientEmail) {
        String url = "https://api.reloadly.com/gift-cards/purchase"; // L'URL pour acheter une carte cadeau

        HttpHeaders headers = new HttpHeaders();
        headers.set("Authorization", "Bearer " + apiKey);
        headers.set("Content-Type", "application/json");

        String body = String.format("{\"brand\": \"%s\", \"amount\": \"%s\", \"recipientEmail\": \"%s\"}",
                brand, amount, recipientEmail);

        HttpEntity<String> entity = new HttpEntity<>(body, headers);
        ResponseEntity<String> response = restTemplate.postForEntity(url, entity, String.class);

        return response.getBody(); // Renvoie la réponse de l'API pour l'achat
    }
}