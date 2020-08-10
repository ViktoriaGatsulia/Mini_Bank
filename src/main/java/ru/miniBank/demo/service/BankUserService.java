package ru.miniBank.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.miniBank.demo.entity.BankUser;
import ru.miniBank.demo.repository.BankUserRepository;

import java.util.List;
import java.util.Optional;

@Service
public class BankUserService {
    private BankUserRepository bankUserRepository;

    @Autowired
    public BankUserService(BankUserRepository bankUserRepository) {
        this.bankUserRepository = bankUserRepository;
    }

    public BankUser save(BankUser bankUser) {
        return bankUserRepository.save(bankUser);
    }

    public Optional<BankUser> findById(Long id) {
        return bankUserRepository.findById(id);
    }

    public List<BankUser> findAll() {
        return bankUserRepository.findAll();
    }
}
