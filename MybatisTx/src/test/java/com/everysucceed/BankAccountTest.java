package com.everysucceed;

import com.es.util.SqlSessionUtils;
import com.everysucceed.mapper.BankAccountMapper;
import org.apache.ibatis.session.SqlSession;
import org.junit.Before;
import org.junit.Test;

import java.math.BigDecimal;

public class BankAccountTest {

    SqlSession session ;
    BankAccountMapper mapper;

    @Before
    public void init(){
        session = SqlSessionUtils.openSession(false);
        mapper = session.getMapper(BankAccountMapper.class);
    }


    @Test
    public void transport(){
       String from = "6217002340007788999";
       String to ="6217002340007788111";
       BigDecimal amount = new BigDecimal("1000");
       try {
           mapper.withdraw(from, amount);
           //
           int i = 10 / 0;
           mapper.deposit(to, amount);
           //提交事务
           session.commit();
       }catch (Exception e){
            session.rollback();
        }finally {
           session.close();
       }


    }

}
