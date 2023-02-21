package com.application.controllers;

import com.application.WalletProxy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OperationTestController {

    private final WalletProxy walletProxy;

    @Autowired
    public OperationTestController(WalletProxy walletProxy) { this.walletProxy = walletProxy; }

    @GetMapping("/operation-service")
    public String operationService(){ return "Operation Service Works !!."; }

    @GetMapping("/test")
    public String testFeign(){
        return walletProxy.walletService();
    }

}
