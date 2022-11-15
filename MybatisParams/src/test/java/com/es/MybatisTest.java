package com.es;

import com.es.entity.Student;
import org.apache.ibatis.session.SqlSession;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

public class MybatisTest {
    SimpleDateFormat simpleDateFormat;
    SqlSession session ;

    @Before
    public void before(){
        session = SqlSessionUtils.sqlSession();
        simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
    }

    @Test
    public void showSession(){
        System.out.println(session);
    }

    @Test
    public void list(){
        List<Student> list = session.selectList("com.es.mapper.StudentMapper.list");
        list.forEach(System.out::println);
    }


    @Test
    public void get(){
        //Student student = session.selectOne("com.es.mapper.StudentMapper.get", "2 or '1'='1'");
        Student student = session.selectOne("com.es.mapper.StudentMapper.get", 3);

        System.out.println(student);

    }

    @Test
    public void listByName(){
        //模糊查询， 先造条件
        List<Student> students = session.selectList("com.es.mapper.StudentMapper.listByName","%苏%");
        students.forEach(System.out::println);
    }

    @Test
    public void listByDate(){
        //模糊查询， 先造条件
       // LocalDate localDate = LocalDate.of(2001,10,9);
        //Instant.from(localDate);
        //System.out.println();
        //不推荐
        Date date = null;
        try {
            date = simpleDateFormat.parse("2001-10-09");
        } catch (ParseException e) {
            e.printStackTrace();
        }
        List<Student> students = session.selectList("com.es.mapper.StudentMapper.getByDate",date);
        students.forEach(System.out::println);
    }

    @Test
    public void listByObject(){
        Student student = new Student();
        student.setName("苏%");
        student.setPhone("132%");
        //
        List<Student> students = session.selectList("com.es.mapper.StudentMapper.getByStudent", student);
    }
    //时间段
    @Test
    public void listByDateRange(){
        try {
            Date start = simpleDateFormat.parse("2000-08-08");
            Date end = simpleDateFormat.parse("2002-09-09");
            HashMap<String, Date> map = new HashMap<>();
            map.put("start", start);
            map.put("end", end);
            List<Student> students = session.selectList("com.es.mapper.StudentMapper.getByDateRange", map);
            students.forEach(System.out::println);
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    @After
    public void after(){
        session.close();
    }
}
