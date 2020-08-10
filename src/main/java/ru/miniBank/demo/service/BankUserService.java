package ru.miniBank.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.miniBank.demo.entity.BankUser;
import ru.miniBank.demo.repository.BankUserRepository;

import java.util.List;
import java.util.Optional;

/**
 * Класс-сервис для BankUser репозитория
 * @autor ViktoriaGatsulia
 * @version 1.0
 */
@Service
public class BankUserService {


    /** Поле для bankUser репозитория */
    private BankUserRepository bankUserRepository;

    /**
     * Конструктор - создание нового объекта
     * @param bankUserRepository - репозиторий для сущность BankUser
     */
    @Autowired
    public BankUserService(BankUserRepository bankUserRepository) {
        this.bankUserRepository = bankUserRepository;
    }

    /**
     * Метод для сохранения нового пользователя в репозитории
     * @param bankUser - новый пользователь
     * @return bankUser - сохранённый пользователь
     */
    public BankUser save(BankUser bankUser) {
        return bankUserRepository.save(bankUser);
    }

    /**
     * Метод для поиска пользователя по идентификатору
     * @param id - идентификатор пользователя
     * @return bankUser - найденный пользователь (optional)
     */
    public Optional<BankUser> findById(Long id) {
        return bankUserRepository.findById(id);
    }

    /**
     * Метод для вывода списка всех пользователей
     * @return спиок пользователей
     */
    public List<BankUser> findAll() {
        return bankUserRepository.findAll();
    }
}
