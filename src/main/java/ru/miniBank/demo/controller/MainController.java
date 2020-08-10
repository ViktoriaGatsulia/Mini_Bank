package ru.miniBank.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.apache.log4j.Logger;
import ru.miniBank.demo.entity.BankUser;
import ru.miniBank.demo.service.BankCardService;
import ru.miniBank.demo.service.BankUserService;

import java.util.Optional;

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

    @PostMapping("/saveBankUser")
    public ResponseEntity saveBankUser(@RequestBody BankUser bankUser ) {
        bankUserService.save(bankUser);
        return ResponseEntity.ok(bankUser);
    }

    @GetMapping("/user_id={user_id}")
    public ResponseEntity findBankUserById(@PathVariable Long user_id) {
        Optional<BankUser> byId = bankUserService.findById(user_id);
        return !byId.isPresent()
                ? ResponseEntity.notFound().build()
                : ResponseEntity.ok(byId);
    }

}
