package ru.miniBank.demo.repository;

import org.springframework.data.cassandra.repository.CassandraRepository;
import org.springframework.stereotype.Repository;
import ru.miniBank.demo.entity.BankCard;

/**
 * Класс репозитоория для сущности BankCard
 * @autor ViktoriaGatsulia
 * @version 1.0
 */
@Repository
public interface BankCardRepository extends CassandraRepository<BankCard, Long> {

}