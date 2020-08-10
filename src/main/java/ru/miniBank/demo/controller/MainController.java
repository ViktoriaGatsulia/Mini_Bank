package ru.miniBank.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.apache.log4j.Logger;
import ru.miniBank.demo.service.BankCardService;
import ru.miniBank.demo.service.BankUserService;

@Controller
@RequestMapping("/")
public class MainController {
    private static final Logger log = Logger.getLogger(MainController.class.getName());

    private BankUserService bankUserService;
    private BankCardService bankCardService;

    @Autowired
    public MainController(BankUserService bankUserService, BankCardService bankCardService) {
        this.bankCardService = bankCardService;
        this.bankUserService = bankUserService;
    }

    @GetMapping
    public ResponseEntity startPage() {
        return ResponseEntity.ok("hello");
    }

}