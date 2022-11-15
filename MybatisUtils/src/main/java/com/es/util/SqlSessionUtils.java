package com.es.util;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.InputStream;

public class SqlSessionUtils {

    private static final String CONFIG_FILE ="mybatis-config.xml";
    private static SqlSessionFactory factory;

    static{
        //
        SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
        InputStream inputStream = SqlSessionUtils.class.getClassLoader().getResourceAsStream(CONFIG_FILE);
        factory = builder.build(inputStream);
        System.out.println(factory);
    }

    public static SqlSession openSession(boolean autoCommit){

        SqlSession session = factory.openSession(autoCommit);
        return session;
    }

    public static SqlSession openSession() {
        return openSession(true);
    }
}
