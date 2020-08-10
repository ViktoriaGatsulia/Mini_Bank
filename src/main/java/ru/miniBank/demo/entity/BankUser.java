package ru.miniBank.demo.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.cassandra.core.cql.Ordering;
import org.springframework.data.cassandra.core.cql.PrimaryKeyType;
import org.springframework.data.cassandra.core.mapping.*;

import java.util.List;

@UserDefinedType("bankUser")
@Table("bankUser")
@Getter
@Setter
@AllArgsConstructor
public class BankUser {

    @Id
    @PrimaryKeyColumn(
            name = "user_id",
            ordinal = 2,
            type = PrimaryKeyType.PARTITIONED,
            ordering = Ordering.DESCENDING
    )
    private Long user_id;

    @Column
    private String userName;

    @CassandraType(type = CassandraType.Name.LIST, typeArguments = {CassandraType.Name.UDT}, userTypeName = "bankCard")
    private List<BankCard> bankCards;

}
