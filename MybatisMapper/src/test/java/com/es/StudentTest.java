package com.es;

import com.es.entity.Student;
import com.es.util.SqlSessionUtils;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.session.SqlSession;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

public class StudentTest {

    SqlSession session ;

    @Before
    public void openSession(){
        session = SqlSessionUtils.openSession();
    }

    @Test
    public void showSqlSession(){
        System.out.println(SqlSessionUtils.openSession());
    }


    @Test
    public void listStudent(){

        List<Student> list = session.selectList("com.es.mapper.StudentMapper.list");

        list.forEach(System.out::println);

    }




}
