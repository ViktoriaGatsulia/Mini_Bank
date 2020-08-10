package ru.miniBank.demo.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.cassandra.core.cql.Ordering;
import org.springframework.data.cassandra.core.cql.PrimaryKeyType;
import org.springframework.data.cassandra.core.mapping.*;

import java.util.Date;

import static org.springframework.data.cassandra.core.mapping.CassandraType.Name.INT;
import static org.springframework.data.cassandra.core.mapping.CassandraType.Name.VARCHAR;

@UserDefinedType("bankCard")
@Table("bankCard")
@Getter
@Setter
@AllArgsConstructor
public class BankCard {

    @Id
    @PrimaryKeyColumn(
            name = "card_id",
            ordinal = 2,
            type = PrimaryKeyType.PARTITIONED,
            ordering = Ordering.DESCENDING
    )
    private Long card_id;

    @Column
    private Date card_expiry_date;

    @Column
    private Integer cvc2;

    @Column
    private String card_number;

    @Column
    private Double balance;

//    @CassandraType(type = CassandraType.Name.ASCII/VARCHAR/INT)
//    @Column
//    private CategoryCard categoryCard;

}
