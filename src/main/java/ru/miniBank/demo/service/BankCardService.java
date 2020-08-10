package ru.miniBank.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.miniBank.demo.entity.BankCard;
import ru.miniBank.demo.repository.BankCardRepository;

import java.util.List;
import java.util.Optional;

@Service
public class BankCardService {
    private BankCardRepository bankCardRepository;

    @Autowired
    public BankCardService(BankCardRepository bankCardRepository) {
        this.bankCardRepository = bankCardRepository;
    }

    public BankCard save(BankCard bankCard) {
        return bankCardRepository.save(bankCard);
    }

    public Optional<BankCard> findById(Long id) {
        return bankCardRepository.findById(id);
    }

    public List<BankCard> findAll() {
        return bankCardRepository.findAll();
    }
}
