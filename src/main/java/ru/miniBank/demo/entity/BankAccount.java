package ru.miniBank.demo.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.cassandra.core.cql.Ordering;
import org.springframework.data.cassandra.core.cql.PrimaryKeyType;
import org.springframework.data.cassandra.core.mapping.*;

import java.util.Date;

//@UserDefinedType("bankAccount")
//@Table("bankAccount")
@Getter
@Setter
@AllArgsConstructor
@ToString
public class BankAccount {

    @Id
    @PrimaryKeyColumn(
            name = "account_id",
            ordinal = 2,
            type = PrimaryKeyType.PARTITIONED,
            ordering = Ordering.DESCENDING
    )
    private long account_id;

    @Column
    private double balanceRuble;

    @Column
    private double balanceDollar;

    @Column
    private double balanceEuro;

}
