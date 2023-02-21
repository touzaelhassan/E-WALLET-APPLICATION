package com.application;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(value = "wallet-service", url = "localhost:8100")
public interface WalletProxy {

    @GetMapping("/wallet-service")
    String walletService();

}
