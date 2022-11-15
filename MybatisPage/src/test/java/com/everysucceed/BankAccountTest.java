package com.everysucceed;

import com.es.util.SqlSessionUtils;
import com.everysucceed.Service.BankAccountService;
import com.everysucceed.Service.impl.BankAccountServiceIml;
import com.everysucceed.entity.BankAccount;
import com.everysucceed.mapper.BankAccountMapper;
import org.apache.ibatis.session.SqlSession;
import org.junit.Before;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.List;

public class BankAccountTest {

    @Test
    public void bankAccountPage(){
        BankAccountService service = new BankAccountServiceIml();
        List<BankAccount> list = service.list(4,2);
        list.forEach(System.out::println);
    }

}
