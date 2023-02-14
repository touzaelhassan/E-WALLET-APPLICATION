package com.application.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WalletTestController {
    @GetMapping("/wallet-message")
    public String getWalletMessage(){ return "Hello From Wallet !!."; }
}
