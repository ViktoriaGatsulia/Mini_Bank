package ru.miniBank.demo.repository;

import org.springframework.data.cassandra.repository.CassandraRepository;
import org.springframework.stereotype.Repository;
import ru.miniBank.demo.entity.BankCard;

@Repository
public interface BankCardRepository extends CassandraRepository<BankCard, Long> {

}