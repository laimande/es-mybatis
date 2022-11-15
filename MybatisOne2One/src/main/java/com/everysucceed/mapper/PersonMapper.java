package com.everysucceed.mapper;

import com.everysucceed.entity.Person;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface PersonMapper {

    //List<Person> list();

    Person get(@Param("id") Integer id);

    Person getByStep(@Param("id") Integer id);

}
