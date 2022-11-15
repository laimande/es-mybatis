package com.everysucceed;

import com.es.util.SqlSessionUtils;
import com.everysucceed.entity.BankAccount;
import com.everysucceed.mapper.BankAccountMapper;
import org.apache.ibatis.session.SqlSession;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.math.BigDecimal;

public class BankAccountTest {

    SqlSession session ;
    BankAccountMapper mapper;

   // @Before
    public void init(){
        session = SqlSessionUtils.openSession(false);
        mapper = session.getMapper(BankAccountMapper.class);
    }


    @Test
    public void get(){
        SqlSession session = SqlSessionUtils.openSession();
        BankAccountMapper mapper = session.getMapper(BankAccountMapper.class);
        BankAccount bankAccount = mapper.get(1);
        System.out.println(bankAccount);
        //
        System.out.println("同一个session中获取同一个对象");
        BankAccount bankAccount1 = mapper.get(1);
        System.out.println(bankAccount);

        System.out.println("不同session中获取同一个对象");
        SqlSession session2 = SqlSessionUtils.openSession();
        BankAccountMapper mapper1 = session2.getMapper(BankAccountMapper.class);
        System.out.println(mapper1.get(1));
    }


    @Test
    public void get1(){
        SqlSession session = SqlSessionUtils.openSession();
        BankAccountMapper mapper = session.getMapper(BankAccountMapper.class);
        //测试二级缓存
        BankAccount bankAccount = mapper.get(1);
        System.out.println(bankAccount);
        //
        System.out.println("同一个session中获取同一个对象");
        BankAccount bankAccount1 = mapper.get(1);
        System.out.println(bankAccount);
        session.close();//
        System.out.println("不同session中获取同一个对象");
        SqlSession session2 = SqlSessionUtils.openSession();
        BankAccountMapper mapper1 = session2.getMapper(BankAccountMapper.class);
        System.out.println(mapper1.get(1));
    }
    /*
    @After
    public void destroy(){
        session.close();
    }
    */


}
