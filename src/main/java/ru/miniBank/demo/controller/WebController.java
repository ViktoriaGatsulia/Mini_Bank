package ru.miniBank.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.miniBank.demo.entity.BankUser;
import ru.miniBank.demo.service.BankCardService;
import ru.miniBank.demo.service.BankUserService;

import java.util.Optional;

@Controller
@RequestMapping("/home")
public class WebController {

    /** Поле сервиса для сущности BankUser */
    private BankUserService bankUserService;

    /** Поле сервиса для сущности BankCard */
    private BankCardService bankCardService;

    /**
     * Конструктор - создание нового объекта
     * @param bankUserService - сервис для сущности BankUser
     * @param bankCardService - сервис для сущности BankCard
     */
    @Autowired
    public WebController(BankUserService bankUserService, BankCardService bankCardService) {
        this.bankCardService = bankCardService;
        this.bankUserService = bankUserService;
    }

    @GetMapping("/getUserById/id={id}")
    public String getUserById(Model model, @PathVariable Long id) {

        Optional<BankUser> userById= bankUserService.findById(id);

        userById.ifPresent(bankUser -> model.addAttribute("userById", bankUser));

        return "index";
    }
}
