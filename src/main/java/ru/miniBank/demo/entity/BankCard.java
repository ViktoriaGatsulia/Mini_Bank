package ru.miniBank.demo.entity;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.cassandra.core.cql.Ordering;
import org.springframework.data.cassandra.core.cql.PrimaryKeyType;
import org.springframework.data.cassandra.core.mapping.*;
import java.util.Date;


/**
 * Класс-сущность для карты пользователя банка MiniBank
 * @autor ViktoriaGatsulia
 * @version 1.0
 */
@UserDefinedType("bankCard")
@Table("bankCard")
@Getter
@Setter
@AllArgsConstructor
@ToString
public class BankCard {

    /** Поле идентификатора карты */
    @Id
    @PrimaryKeyColumn(
            name = "card_id",
            ordinal = 2,
            type = PrimaryKeyType.PARTITIONED,
            ordering = Ordering.DESCENDING
    )
    private long card_id;

    /** Дата до которой действует банковская карта */
    @Column
    private Date card_expiry_date;

    /** Защитный код */
    @Column
    private int cvc2;

    /** Номер банковской карты */
    @Column
    private String card_number;

    /** Баланс банковской карты */
    @Column
    private double balance;

    /** Категория банковской карты */
    @CassandraType(type = CassandraType.Name.VARCHAR)
    private CategoryCard categoryCard;

}
