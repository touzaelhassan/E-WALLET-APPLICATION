package com.application;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(value = "wallet-service", url = "localhost:8000")
public interface WalletProxy {
    @GetMapping("/wallet-message")
    public String getWalletMessage();
}
