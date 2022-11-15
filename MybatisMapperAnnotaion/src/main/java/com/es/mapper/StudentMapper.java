package com.es.mapper;

import com.es.entity.Student;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface StudentMapper {

    /**
     * 用来保存学生信息的方法
     * @param student
     * @return
     */
    @Insert("insert into student(id,name,birthday,address,phone) values (null,#{name},#{birthday},#{address},#{phone})")
    int save(Student student);

    /**
     * 更新学生信息
     * @param student
     * @return
     */
    @Update("update student set name=#{name},birthday=#{birthday},address=#{address},phone=#{phone} where id=#{id}")
    int update(Student student);


    /**
     * 删除一条学生信息
     * @param id
     * @return
     */
    @Delete("delete from student where id=#{id}")
    int delete(@Param("id")Integer id);

    /**
     * 根据ID查询学生信息
     * @param id
     * @return
     */
    @Select("select id,name,address,phone,birthday from student where id=#{id}")
    @ResultType(Student.class)
    Student get(@Param("id") Integer id);

    /**
     * @return
     */
    @Select("select * from student")
    @ResultType(Student.class)
    List<Student> list();


    @Select("select * from student where name like #{name} and phone like #{phone}")
    @ResultType(Student.class)
    List<Student> listByCondition(@Param("name") String name, @Param("phone") String phone);

}
