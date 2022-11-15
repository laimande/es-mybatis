package com.everysucceed;

import com.es.util.SqlSessionUtils;
import com.everysucceed.entity.Person;
import com.everysucceed.mapper.PersonMapper;
import org.junit.Before;
import org.junit.Test;

public class One2OneTest {

    PersonMapper mapper ;

    @Before
    public void getMapper(){
        mapper = SqlSessionUtils.openSession().getMapper(PersonMapper.class);
    }

    @Test
    public void get(){
        Person person = mapper.get(1);
       // System.out.println(person);
        System.out.println("ID\t姓名\t身份证号\t有效期");
        System.out.println(person.getId()+"\t"+person.getName()+"\t"+person.getIdCard().getId()+"\t"+person.getIdCard().getExpDateStart()+"-"+person.getIdCard().getExpDateEnd());
    }

    @Test
    public void getByStep(){
        Person person = mapper.getByStep(1);
        // System.out.println(person);
        ///System.out.println("ID\t姓名\t身份证号\t有效期");
       // System.out.println(person.getId()+"\t"+person.getName()+"\t"+person.getIdCard().getId()+"\t"+person.getIdCard().getExpDateStart()+"-"+person.getIdCard().getExpDateEnd());
        System.out.println(person.getName());
        System.out.println(person.getIdCard().getId());
    }

}
