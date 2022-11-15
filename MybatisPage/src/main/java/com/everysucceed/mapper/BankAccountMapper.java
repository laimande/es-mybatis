package com.everysucceed.mapper;

import com.everysucceed.entity.BankAccount;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Update;

import java.math.BigDecimal;
import java.util.List;

public interface BankAccountMapper {

    @Update("update bank_account set balance=balance+#{amount} where card_no = #{cardNo}")
    int deposit(@Param("cardNo") String cardNo,@Param("amount") BigDecimal amount);

    @Update("update bank_account set balance = balance-#{amount} where card_no = #{cardNo}")
    int withdraw(@Param("cardNo")String cardNo,@Param("amount") BigDecimal amount);

    BankAccount get(@Param("id") Integer id);


    List<BankAccount> list();
}
