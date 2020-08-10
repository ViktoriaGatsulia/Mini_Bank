package ru.miniBank.demo.service;

//import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.miniBank.demo.entity.BankCard;
import ru.miniBank.demo.repository.BankCardRepository;

import java.util.List;
import java.util.Optional;

/**
 * Класс-сервис для BankCard репозитория
 * @autor ViktoriaGatsulia
 * @version 1.0
 */
@Service
public class BankCardService {

    /** Поле для BankCard репозитория */
    private BankCardRepository bankCardRepository;

    /**
     * Конструктор - создание нового объекта
     * @param bankCardRepository - репозиторий для сущности BankCard
     */
    @Autowired
    public BankCardService(BankCardRepository bankCardRepository) {
        this.bankCardRepository = bankCardRepository;
    }

    /**
     * Метод для сохранения новой банковской карты
     * @param bankCard - банковская карта - кандидат на сохранение
     * @return bankCard - сохранённоая банковская карта
     */
    public BankCard save(BankCard bankCard) {
        return bankCardRepository.save(bankCard);
    }

    /**
     * Метод для поиска банковской карты по индентификационному номеру
     * @param id - идентификациооный номер
     * @return bankCard - найденная карта (optional)
     */
    public Optional<BankCard> findById(Long id) {
        return bankCardRepository.findById(id);
    }

    /**
     * Метод для вывода списка всех банковских карт
     * @return - список банковских карт
     */
    public List<BankCard> findAll() {
        return bankCardRepository.findAll();
    }
}
