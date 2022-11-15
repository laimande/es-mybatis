package com.es;

import com.es.entity.Student;
import com.es.mapper.StudentMapper;
import com.es.util.SqlSessionUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Before;
import org.junit.Test;

import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;

public class StudentMapperTest {

    SqlSession session ;
    StudentMapper mapper;//接口？？

    @Before
    public void openSession(){
        session = SqlSessionUtils.openSession();
        mapper = session.getMapper(StudentMapper.class);
    }

    @Test
    public void listStudent(){
        System.out.println(mapper);
        List<Student> list = mapper.list();
        list.forEach(System.out::println);
    }
    @Test
    public void saveStudent(){
       Student student = new Student();
       student.setName("葛忠良");
       Date birthday = Date.from(Instant.from( LocalDate.of(2000,12,24).atStartOfDay().atZone(ZoneId.systemDefault())));
       //Date birthday = Date.from()
       student.setBirthday(birthday);
       student.setAddress("山东济南");
       student.setPhone("18612324556");
        System.out.println(birthday);

        mapper.save(student);
    }

    //@After

    @Test
    public void deleteStudent(){
        int i = mapper.delete(4);
        System.out.println(i);
    }

    @Test
    public void updateStudent(){
        Student student = new Student();
        student.setId(4);
        student.setName("任振坤");
        student.setAddress("山东青岛");
        student.setBirthday(Date.from(Instant.from( LocalDate.of(2001,12,3).atStartOfDay().atZone(ZoneId.systemDefault()))));
        student.setPhone("13212345678");

        int i = mapper.update(student);
        System.out.println(i);
    }

    @Test
    public void getStudent(){
        Student student = mapper.get(8);
        System.out.println(student);
    }

    @Test
    public void listByConditon(){
        //
        List<Student> list = mapper.listByCondition("苏%","%1234%");
        list.forEach(System.out::println);
    }
}
