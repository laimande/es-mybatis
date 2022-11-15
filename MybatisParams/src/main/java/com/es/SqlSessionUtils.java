package com.es;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.InputStream;

public class SqlSessionUtils {
    private static final String CONFIG_FILE = "mybatis-config.xml";

    public static SqlSession sqlSession(){
        //
        InputStream inputStream = SqlSessionUtils.class.getClassLoader().getResourceAsStream(CONFIG_FILE);
        SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
        SqlSessionFactory factory = builder.build(inputStream);
        SqlSession session = factory.openSession();
        return session;
    }
}
