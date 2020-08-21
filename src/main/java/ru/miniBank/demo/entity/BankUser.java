package ru.miniBank.demo.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.cassandra.core.cql.Ordering;
import org.springframework.data.cassandra.core.cql.PrimaryKeyType;
import org.springframework.data.cassandra.core.mapping.*;

import java.util.Date;
import java.util.List;
import java.util.Objects;

/**
 * Класс-сущность для пользователя банка MiniBank
 * @autor ViktoriaGatsulia
 * @version 1.0
 */
//@UserDefinedType("bankUser")
@Table("bankUser")
@ToString
public class BankUser {

    /** Поле идентификатора пользователя */
    @Getter
    @Setter
    @Id
    @PrimaryKeyColumn(
            name = "user_id",
            ordinal = 2,
            type = PrimaryKeyType.PARTITIONED,
            ordering = Ordering.DESCENDING
    )
    private long user_id;

    /** Поле имени пользователя */
    @Getter
    @Setter
    @Column
    private String userName;

    /** Поле для электронной почты пользователя */
    @Getter
    @Setter
    @Column
    private String email;

    /** Поле даты рождения пользователя */
    @Getter
    @Setter
    @Column
    private Date birthday;

    /** Список банковских карт пользователя */
    @Getter
    @Setter
    @CassandraType(type = CassandraType.Name.LIST, typeArguments = {CassandraType.Name.UDT}, userTypeName = "bankCard")
    private List<BankCard> bankCard = null;

    /** Счёт пользователя - сумма сбережений со всех карт */
    @Transient
    private double bankAccount;

    public BankUser (long user_id, String userName, String email, Date birthday, List<BankCard> bankCard) {
        this.user_id = user_id;
        this.userName = userName;
        this.email = email;
        this.birthday = birthday;
        this.bankCard = bankCard;
    }

    public double getBankAccount() {
        if (Objects.isNull(bankCard)) return 0D;
        double buff = 0D;
        for (BankCard card : bankCard)
            buff += card.getBalance();
        return buff;
    }
    public void setBankAccount() {
        if (Objects.isNull(bankCard)) bankAccount = 0D;
        double buff = 0D;
        for (BankCard card : bankCard)
            buff += card.getBalance();
        bankAccount = buff;
    }
}
/*
curl -H 'Content-Type:application/json' -d '{"user_id" : 1, "userName" : "Viktoria", "bankCard" : null}' '127.0.0.1:8080/saveBankUser'
 */