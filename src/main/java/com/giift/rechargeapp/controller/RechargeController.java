package com.giift.rechargeapp.controller;


import com.giift.rechargeapp.service.ReloadlyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/recharge")
public class RechargeController {

    @Autowired
    private ReloadlyService reloadlyService;

    @PostMapping("/telecom")
    public ResponseEntity<String> rechargeTelecom(
            @RequestParam String phoneNumber,
            @RequestParam String amount,
            @RequestParam String operatorId,
            @RequestParam String email) {
        // Appel du service de recharge
        String response = reloadlyService.rechargePhone(phoneNumber, amount, operatorId, email);
        return ResponseEntity.ok(response);
    }

    // Autres méthodes pour obtenir la liste des opérateurs et des pays peuvent être ajoutées ici
}
