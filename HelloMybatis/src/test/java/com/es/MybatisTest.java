package com.es;

import com.es.entity.SysUser;
import org.apache.ibatis.session.SqlSession;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

public class MybatisTest {

    SqlSession session ;

    @Before
    public void openSession(){
        session = SqlSessionUtils.getSqlSession();
    }


    @Test
    public void show(){
        System.out.println(session);
    }

    @Test
    public void listSysUser(){
        List<SysUser> list = session.selectList("com.es.entity.SysUser.list");
        list.forEach(System.out::println);
        session.close();
    }

    @After
    public void closeSession(){
        session.close();
    }
}
