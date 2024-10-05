package com.giift.rechargeapp.controller;

import com.giift.rechargeapp.service.GiftCardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/gift-cards")
public class GiftCardController {

    @Autowired
    private GiftCardService giftCardService;

    @GetMapping
    public ResponseEntity<?> getAllGiftCards() {
        // Récupérer toutes les cartes cadeaux
        return ResponseEntity.ok(giftCardService.getAllGiftCards());
    }

    @PostMapping
    public ResponseEntity<String> purchaseGiftCard(
            @RequestParam String brand,
            @RequestParam String amount,
            @RequestParam String recipientEmail) {
        // Appel du service pour acheter une carte cadeau
        String response = giftCardService.purchaseGiftCard(brand, amount, recipientEmail);
        return ResponseEntity.ok(response);
    }
}