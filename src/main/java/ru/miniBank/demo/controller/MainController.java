package ru.miniBank.demo.controller;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import ru.miniBank.demo.entity.BankCard;
import ru.miniBank.demo.entity.BankUser;
import ru.miniBank.demo.service.BankCardService;
import ru.miniBank.demo.service.BankUserService;

import java.util.Optional;

/**
 * Класс основного контроллера
 * @autor ViktoriaGatsulia
 * @version 1.0
 */
@RestController
@RequestMapping("/")
public class MainController {
    /** Поле для логирования */
    private static final Logger log = Logger.getLogger(MainController.class.getName());


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
        log.info("MainController create");
    }

    /**
     * Get метод для отображения стартовой страниц
     * @return "hello" - фраза для приветсвия
     */
    @GetMapping
    public ResponseEntity startPage() {
        log.info("call start page");
        return ResponseEntity.ok("hello");
    }

    /**
     * Post метод для сохранения пользователя
     * @param bankUser - кандидат на сохранение
     * @return bankUser - сохранённый пользователь (MediaType.APPLICATION_JSON)
     */
    @PostMapping("/saveBankUser")
    public ResponseEntity saveBankUser(@RequestBody BankUser bankUser) {
        log.info("call /saveBankUser " + bankUser.toString());
        bankUserService.save(bankUser);
        return ResponseEntity.ok(bankUser);
    }

    /**
     * Get метод для поиска пользователя по id
     * @param user_id - индентификатор пользователя
     * @return bankUser - найденный пользователь (MediaType.APPLICATION_JSON)
     */
    @GetMapping("/user_id={user_id}")
    public ResponseEntity findBankUserById(@PathVariable Long user_id) {
        log.info("call /user_id=" + user_id);
        Optional<BankUser> byId = bankUserService.findById(user_id);
        return !byId.isPresent()
                ? ResponseEntity.notFound().build()
                : ResponseEntity.ok(byId);
    }

    /**
     * Post метод для сохранения банковской карты
     * @param bankCard - кандидат на сохранение
     * @return bankCard - сохранённая банковская карта (MediaType.APPLICATION_JSON)
     */
    @PostMapping("/saveBankCard")
    public ResponseEntity saveBankCard(@RequestBody BankCard bankCard) {
        log.info("call /saveBankCard " + bankCard.toString());
        bankCardService.save(bankCard);
        return ResponseEntity.ok(bankCard);
    }

    /**
     * Get метод для поиска банковской карты по id
     * @param card_id - индентификатор банковской карты
     * @return bankCard - сохранённая банковская карта (MediaType.APPLICATION_JSON)
     */
    @GetMapping("/card_id={card_id}")
    public ResponseEntity findBankCardById(@PathVariable Long card_id) {
        log.info("call /card_id=" + card_id);
        Optional<BankCard> byId = bankCardService.findById(card_id);
        return !byId.isPresent()
                ? ResponseEntity.notFound().build()
                : ResponseEntity.ok(byId);
    }

    @GetMapping("/findAllBankUser")
    public ResponseEntity findAllBankUser() {
        log.info("call /findAllBankUser");
        return ResponseEntity.ok(bankUserService.findAll());
    }

    @GetMapping("/findAllBankCard")
    public ResponseEntity findAllBankCard() {
        log.info("call /findAllBankCard");
        return ResponseEntity.ok(bankCardService.findAll());
    }

    @PostMapping("/addCardForUser/user_id={id}")
    public ResponseEntity addCardForUser(@PathVariable Long id, @RequestBody BankCard bankCard) {
        log.info("call /addCardForUser/user_id= " + id);
        Optional<BankUser> byId = bankUserService.findById(id);
        byId.ifPresent(bankUser -> bankUser.addCard(bankCard));
        byId.ifPresent(bankUser -> bankUserService.save(bankUser));
        return !byId.isPresent()
                ? ResponseEntity.notFound().build()
                : ResponseEntity.ok(byId);
    }
}
