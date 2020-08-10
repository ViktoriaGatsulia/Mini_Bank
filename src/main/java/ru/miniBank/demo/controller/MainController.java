package ru.miniBank.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import ru.miniBank.demo.entity.BankUser;
import ru.miniBank.demo.service.BankCardService;
import ru.miniBank.demo.service.BankUserService;

import java.util.Optional;

/**
 * Класс основного контроллера
 * @autor ViktoriaGatsulia
 * @version 1.0
 */
@Controller
@RequestMapping("/")
public class MainController {

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
    public MainController(BankUserService bankUserService, BankCardService bankCardService) {
        this.bankCardService = bankCardService;
        this.bankUserService = bankUserService;
    }

    /**
     * Get метод для отображения стартовой страниц
     * @return "hello" - фраза для приветсвия
     */
    @GetMapping
    public ResponseEntity startPage() {
        return ResponseEntity.ok("hello");
    }

    /**
     * Post метод для сохранения пользователя
     * @param bankUser - кандидат на сохранение
     * @return bankUser (MediaType.APPLICATION_JSON)
     */
    @PostMapping("/saveBankUser")
    public ResponseEntity saveBankUser(@RequestBody BankUser bankUser ) {
        bankUserService.save(bankUser);
        return ResponseEntity.ok(bankUser);
    }

    /**
     * Get метод для поиска пользователя по id
     * @param user_id - индентификатор пользователя
     * @return bankUser (MediaType.APPLICATION_JSON)
     */
    @GetMapping("/user_id={user_id}")
    public ResponseEntity findBankUserById(@PathVariable Long user_id) {
        Optional<BankUser> byId = bankUserService.findById(user_id);
        return !byId.isPresent()
                ? ResponseEntity.notFound().build()
                : ResponseEntity.ok(byId);
    }

}
