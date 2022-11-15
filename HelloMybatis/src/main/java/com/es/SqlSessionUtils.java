package com.es;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.InputStream;

public class SqlSessionUtils {

    private static final String CONFIG_FILE_NAME = "mybatis-config.xml";

    public static SqlSession getSqlSession(){
        SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
        //类路径下获取配置文件
        InputStream inputStream = SqlSessionUtils.class.getClassLoader().getResourceAsStream(CONFIG_FILE_NAME);
        //通过读取指定的配置文件，和环境id，得到一个sqlSessionFactory
        SqlSessionFactory sqlSessionFactory = builder.build(inputStream);
        System.out.println(inputStream);
        SqlSession session = sqlSessionFactory.openSession();
        return session;
    }
}
