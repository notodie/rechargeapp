package com.giift.rechargeapp.controller;

import com.giift.rechargeapp.service.UtilityPaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/utilities")
public class UtilityPaymentController {

    @Autowired
    private UtilityPaymentService utilityPaymentService;

    @PostMapping("/pay")
    public ResponseEntity<String> payUtility(
            @RequestParam String utilityType,
            @RequestParam String accountNumber,
            @RequestParam String amount) {
        // Appel du service pour payer une facture de service public
        String response = utilityPaymentService.payUtility(utilityType, accountNumber, amount);
        return ResponseEntity.ok(response);
    }

    // D'autres méthodes pour obtenir des informations sur les services publics peuvent être ajoutées ici
}