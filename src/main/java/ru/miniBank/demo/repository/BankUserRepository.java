package ru.miniBank.demo.repository;

import org.springframework.data.cassandra.repository.CassandraRepository;
import org.springframework.stereotype.Repository;
import ru.miniBank.demo.entity.BankUser;

/**
 * Класс репозитоория для сущности BankUser
 * @autor ViktoriaGatsulia
 * @version 1.0
 */
@Repository
public interface BankUserRepository extends CassandraRepository<BankUser, Long> {

}