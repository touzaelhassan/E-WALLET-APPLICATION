package com.application.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WalletTestController {
    @GetMapping("/wallet-service")
    public String walletService(){ return "Wallet Service Works !!."; }
}
