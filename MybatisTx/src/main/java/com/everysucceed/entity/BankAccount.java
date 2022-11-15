package com.everysucceed.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.math.BigDecimal;

@Data
@NoArgsConstructor
public class BankAccount implements Serializable {

    private Integer id;
    private String name;
    private String idCard;
    private String cardNO;
    private BigDecimal balance;
}
